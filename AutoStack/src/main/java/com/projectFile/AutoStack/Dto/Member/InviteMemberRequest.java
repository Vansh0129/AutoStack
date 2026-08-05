package com.projectFile.AutoStack.Dto.Member;

import com.projectFile.AutoStack.Entity.Enum.ProjectRoles;
import jakarta.validation.constraints.Email;

public record InviteMemberRequest(
       @Email String email,
        ProjectRoles role
) {
}
