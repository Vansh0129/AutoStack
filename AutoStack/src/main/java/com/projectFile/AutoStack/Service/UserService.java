package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;


public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
