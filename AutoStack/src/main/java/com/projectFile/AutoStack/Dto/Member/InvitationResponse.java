package com.projectFile.AutoStack.Dto.Member;

import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;

import java.time.Instant;

public record InvitationResponse(Long projectId,
                                 String projectName,
                                 UserProfileResponse owner,
                                 Instant createdOn,
                                 Instant updatedOn,
                                 Instant invitedAt) {
}
