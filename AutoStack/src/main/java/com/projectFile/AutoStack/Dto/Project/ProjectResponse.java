package com.projectFile.AutoStack.Dto.Project;

import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;

import java.time.Instant;


public record ProjectResponse(
        Long id,
        String name,
        UserProfileResponse owner,
        Instant createdOn,
        Instant updatedOn


) {

}
