package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
