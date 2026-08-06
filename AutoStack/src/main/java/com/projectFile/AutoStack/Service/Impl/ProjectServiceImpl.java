package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectRequest;
import com.projectFile.AutoStack.Dto.Project.ProjectResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectSummeryResponse;
import com.projectFile.AutoStack.Entity.Enum.ProjectRoles;
import com.projectFile.AutoStack.Entity.Project;
import com.projectFile.AutoStack.Entity.ProjectMember;
import com.projectFile.AutoStack.Entity.ProjectMemberId;
import com.projectFile.AutoStack.Entity.User;
import com.projectFile.AutoStack.Repository.ProjectMemberRepo;
import com.projectFile.AutoStack.Repository.ProjectRepo;
import com.projectFile.AutoStack.Repository.UserRepo;
import com.projectFile.AutoStack.Service.ProjectService;
import com.projectFile.AutoStack.mapper.ProjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional

public class ProjectServiceImpl implements ProjectService {
    ProjectRepo projectRepo;
    UserRepo userRepo;
    ProjectMemberRepo projectMemberRepo;
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
//        TODO :check if user is valid and have AI credit to create this?
        User user = userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException(("Invalid user Id :" + userId)));
        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        project = projectRepo.save(project);
        ProjectMember projectMember = ProjectMember.builder()
                .id(new ProjectMemberId(project.getId(), userId))
                .project(project)
                .user(user)
                .role(ProjectRoles.OWNER)
                .invitedAt(Instant.now())
                .acceptedAt(Instant.now())
                .build();
        projectMemberRepo.save(projectMember);
        return projectMapper.toProjectResponse(project,new UserProfileResponse(userId,user.getName(),user.getAvtarUrl(),user.getEmail()));
    }

    @Override
    public List<ProjectSummeryResponse> getAllProjects(Long userId) {       //also get owned and also shared projects.
        List<Project> projects = projectRepo.getAllAccessibleProject(userId);
        return projectMapper.toListProjectSummeryResponse(projects);
    }

    @Override
    public ProjectResponse getProjectById(Long projectId, Long userId) {
        Project project = projectRepo.getAllAccessibleProjectById(userId, projectId).orElseThrow(() -> new NoSuchElementException("Un-Authorized : Project does not belong to user ! "));
        return projectMapper.toProjectResponse(project);
    }


    @Override
    public ProjectResponse updateProjects(Long projectId, Long userId, ProjectRequest projectRequest) {
        Project project = projectRepo.getAllAccessibleProjectById(userId, projectId).orElseThrow(() -> new NoSuchElementException("Un-Authorized : Project does not belong to user ! "));

        project.setName(projectRequest.name());
        project = projectRepo.save(project);
        return projectMapper.toProjectResponse(project);


    }

    @Override
    public ProjectResponse deleteProjects(Long projectId, Long userId) {
        Project project = projectRepo.getAllAccessibleProjectById(userId, projectId).orElseThrow(() -> new NoSuchElementException("Un-Authorized : Project does not belong to user ! "));
        project.setDeletedAt(Instant.now());        //soft deleted
//           project= projectRepo.save(project);        transaction auto do this!

//        projectRepo.deleteById(projectId); do not delete directly!
        return projectMapper.toProjectResponse(project);
    }

}

