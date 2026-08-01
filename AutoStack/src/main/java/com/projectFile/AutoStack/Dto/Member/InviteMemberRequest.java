package com.projectFile.AutoStack.Dto.Member;

import com.projectFile.AutoStack.Entity.Enum.ProjectRoles;

public record InviteMemberRequest(
        String email,
        ProjectRoles role
) {
}
