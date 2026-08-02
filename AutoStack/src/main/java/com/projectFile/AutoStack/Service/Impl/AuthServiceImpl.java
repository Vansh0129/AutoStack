package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Auth.AuthResponse;
import com.projectFile.AutoStack.Dto.Auth.Login;
import com.projectFile.AutoStack.Dto.Auth.SignUp;
import com.projectFile.AutoStack.Service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signUp(SignUp login) {
        return null;
    }

    @Override
    public AuthResponse login(Login loginReq) {
        return null;
    }
}
