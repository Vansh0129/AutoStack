package com.projectFile.AutoStack.Service;


import com.projectFile.AutoStack.Dto.Member.InvitationRequest;
import com.projectFile.AutoStack.Dto.Member.InvitationResponse;
import com.projectFile.AutoStack.Dto.Member.InviteMemberRequest;
import com.projectFile.AutoStack.Dto.Member.MemberResponse;
import com.projectFile.AutoStack.Dto.Project.UpdateMemberRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectMemberService {
    List<MemberResponse> GetAllMembers(Long projectId, Long userId);

    MemberResponse InviteMember(Long projectId, Long userId, InviteMemberRequest request);

    MemberResponse UpdateRole(Long projectId, Long memberId, UpdateMemberRequest request, Long userId);

    void DeleteProjectMember(Long projectId, Long memberId, Long userId);

    List<InvitationResponse> GetAllPendingMembersRequest(Long userId);

    void AcceptInviteMember(Long projectId, Long userId, InvitationRequest request);
}
