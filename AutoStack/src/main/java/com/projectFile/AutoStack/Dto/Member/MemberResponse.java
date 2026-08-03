package com.projectFile.AutoStack.Dto.Member;

import com.projectFile.AutoStack.Entity.Enum.ProjectRoles;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String name,
        String avtarUrl,
        String email,
        Instant invitedAt,
        ProjectRoles role
) {
}
