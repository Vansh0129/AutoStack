package com.projectFile.AutoStack.Dto.Member;


import java.time.Instant;

public record InvitationResponse(Long projectId,
                                 String projectName,
                                 Instant createdOn,
                                 Instant updatedOn,
                                 Instant invitedAt) {
}
