package com.projectFile.AutoStack.Dto.Auth;

public record UserProfileResponse(
        Long id,
        String name,
        String avtarUrl,
        String email
) {

}
