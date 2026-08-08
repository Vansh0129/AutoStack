package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Auth.AuthResponse;
import com.projectFile.AutoStack.Dto.Auth.Login;
import com.projectFile.AutoStack.Dto.Auth.SignUp;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;


@Service
public interface AuthService {
    AuthResponse signUp(SignUp login);

    AuthResponse login(Login loginReq) throws AccessDeniedException;
}
