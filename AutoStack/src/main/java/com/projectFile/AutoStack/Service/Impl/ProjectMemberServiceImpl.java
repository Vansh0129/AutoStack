package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Member.InviteMemberRequest;
import com.projectFile.AutoStack.Dto.Member.MemberResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectResponse;
import com.projectFile.AutoStack.Dto.Project.ProjectSummeryResponse;
import com.projectFile.AutoStack.Dto.Project.UpdateMemberRequest;
import com.projectFile.AutoStack.Service.ProjectMemberService;
import com.projectFile.AutoStack.Service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {


    @Override
    public List<MemberResponse> GetAllMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse InviteMember(Long projectId, Long userId, InviteMemberRequest request) {
        return null;
    }

    @Override
    public MemberResponse UpdateRole(Long projectId, Long memberId, UpdateMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse DeleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
