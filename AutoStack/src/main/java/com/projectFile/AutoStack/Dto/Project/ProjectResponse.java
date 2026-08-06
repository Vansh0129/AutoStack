package com.projectFile.AutoStack.Dto.Project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        @JsonInclude(JsonInclude.Include.NON_NULL) UserProfileResponse owner,
        Instant createdAt,
        Instant updatedAt


) {

}
