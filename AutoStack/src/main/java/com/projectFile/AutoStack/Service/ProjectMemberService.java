package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Member.InviteMemberRequest;
import com.projectFile.AutoStack.Dto.Member.MemberResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectMemberService {
    List<MemberResponse> GetAllMembers(Long projectId, Long userId);

    MemberResponse InviteMember(Long projectId, Long userId, InviteMemberRequest request);

    MemberResponse UpdateRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId);

    MemberResponse DeleteProjectMember(Long projectId, Long memberId, Long userId);
}
