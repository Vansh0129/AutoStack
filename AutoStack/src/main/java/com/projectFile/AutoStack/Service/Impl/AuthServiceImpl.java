package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Auth.AuthResponse;
import com.projectFile.AutoStack.Dto.Auth.Login;
import com.projectFile.AutoStack.Dto.Auth.SignUp;
import com.projectFile.AutoStack.Entity.User;
import com.projectFile.AutoStack.Repository.UserRepo;
import com.projectFile.AutoStack.Security.AuthUtil;
import com.projectFile.AutoStack.Service.AuthService;
import com.projectFile.AutoStack.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepo userRepo;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    AuthUtil authUtil;

    @Override
    public AuthResponse signUp(SignUp login) {
        if (userRepo.findByEmail(login.email()).isPresent())
            throw new BadCredentialsException("User Already Exist With UserName: " + login.email());
        User user = userMapper.toUserFromSignUp(login);
        user.setPassword(passwordEncoder.encode(login.password()));
        user = userRepo.save(user);
        return userMapper.toAuthResponseFromUserAccess(authUtil.RefreshToken(user), user);

    }

    @Override
    public AuthResponse login(Login loginReq) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(loginReq.username(), loginReq.password())
                );
        User user= (User) authentication.getPrincipal();
        return userMapper.toAuthResponseFromUserAccess(authUtil.RefreshToken(user), user);

    }
}
