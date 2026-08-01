package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Auth.SignUp;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    AuthResponse signUp(SignUp login);
}
