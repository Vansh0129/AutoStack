package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Member.InvitationRequest;
import com.projectFile.AutoStack.Dto.Member.InviteMemberRequest;
import com.projectFile.AutoStack.Dto.Member.MemberResponse;
import com.projectFile.AutoStack.Dto.Project.UpdateMemberRequest;

import com.projectFile.AutoStack.Entity.Enum.InvitationOption;
import com.projectFile.AutoStack.Entity.Project;
import com.projectFile.AutoStack.Dto.Member.InvitationResponse;
import com.projectFile.AutoStack.Entity.ProjectMember;
import com.projectFile.AutoStack.Entity.ProjectMemberId;
import com.projectFile.AutoStack.Entity.User;
import com.projectFile.AutoStack.Repository.ProjectMemberRepo;
import com.projectFile.AutoStack.Repository.ProjectRepo;
import com.projectFile.AutoStack.Repository.UserRepo;
import com.projectFile.AutoStack.Service.ProjectMemberService;
import com.projectFile.AutoStack.mapper.ProjectMemberMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepo projectMemberRepo;
    ProjectRepo projectRepo;
    ProjectMemberMapper projectMemberMapper;
    UserRepo userRepo;

//    projectMemberRepo.findById not work because it is compact so consider to use 'findByIdProjectIdAndMemberId()'

    @Override
    public MemberResponse InviteMember(Long projectId, Long userId, InviteMemberRequest request) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new NoSuchElementException("Invalid project Id !"));
        User invitee = userRepo.findByEmail(request.email()).orElseThrow(() -> new NoSuchElementException("Invalid Email,Cannot find the User !"));

        if (!Objects.equals(project.getOwner().getId(), userId))
            throw new RuntimeException("Un-Authorized to do Invite Member !");
        if (Objects.equals(invitee.getId(), userId)) throw new RuntimeException("You cannot invite your self!");
        if(projectMemberRepo.findByIdProjectIdAndMemberId(projectId, invitee.getId()).isPresent()) throw new RuntimeException("User is already member of Project !");


        ProjectMember projectMember = ProjectMember.builder()
                .invitedAt(Instant.now())
                .id(new ProjectMemberId(projectId,invitee.getId()))
                .user(invitee)
                .project(project)
                .role(request.role())
                .build();

        projectMember = projectMemberRepo.save(projectMember);
        return projectMemberMapper.toMemberResponseFromMember(projectMember);


    }

    @Override
    public List<MemberResponse> GetAllMembers(Long projectId, Long userId) {
        Project project = projectRepo.getAllAccessibleProjectById(userId, projectId).orElseThrow(() -> new NoSuchElementException("Un-Authorized : Project does not belong to user ! "));

        List<MemberResponse> membersOfProject = new ArrayList<>();
        membersOfProject.addAll(projectMemberRepo.findAllByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toMemberResponseFromMember)
                .toList());
        User owner = project.getOwner();

        membersOfProject.add(projectMemberMapper.toMemberResponseFromOwner(owner));

        return membersOfProject;


    }

    @Override
    public MemberResponse UpdateRole(Long projectId, Long memberId, UpdateMemberRequest request, Long userId) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new NoSuchElementException("Invalid project Id !"));

        if (!Objects.equals(project.getOwner().getId(), userId))
            throw new RuntimeException("Un-Authorized to do Invite Member !");
        ProjectMember resource=projectMemberRepo.findByIdProjectIdAndMemberId(projectId,memberId).orElseThrow(() -> new NoSuchElementException("Member not found !"));;
        resource.setRole(request.role());
        resource=projectMemberRepo.save(resource);
        return projectMemberMapper.toMemberResponseFromMember(resource);
    }

    @Override
    public void DeleteProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new NoSuchElementException("Invalid project Id !"));
        if (!Objects.equals(project.getOwner().getId(), userId))
            throw new RuntimeException("Un-Authorized to do Invite Member !");
        ProjectMember member=projectMemberRepo.findByIdProjectIdAndMemberId(projectId,memberId).orElseThrow(() -> new NoSuchElementException("Member not found !"));;
        projectMemberRepo.delete(member);
    }
//Member Api Service

    @Override
    public List<InvitationResponse> GetAllPendingMembersRequest(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException("Invalid User,Cannot find the Record !"));
        List<ProjectMember> list=projectMemberRepo.findAllPendingRequest(user);

        return list.stream().map(projectMemberMapper::toInvitationResponseFromProjectMember).toList();

    }

    @Override
    public void AcceptInviteMember(Long projectId, Long userId, InvitationRequest request) {
        User user = userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException("Invalid User,Cannot find the Record !"));
        ProjectMember member=projectMemberRepo.ResponseToPendingReq(user ,projectId).orElseThrow(() -> new NoSuchElementException("Request not found !"));
        if(request.response().equals(InvitationOption.ACCEPT)){
            member.setAcceptedAt(Instant.now());
           projectMemberRepo.save(member);
        }else{
            projectMemberRepo.delete(member);
        }


    }
}
