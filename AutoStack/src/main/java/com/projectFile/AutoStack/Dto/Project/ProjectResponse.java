package com.projectFile.AutoStack.Dto.Project;

import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;

import java.time.Instant;

public class ProjectResponse {
    Long id;
    String name;
    Instant cretedAt;
    Instant updatedAt;
    UserProfileResponse owner;
}
