package com.projectFile.AutoStack.Dto.Member;


import java.time.Instant;

public record InvitationResponse(Long projectId,
                                 String projectName,
                                 Instant createdAt,
                                 Instant updatedAt,
                                 Instant invitedAt) {
}
