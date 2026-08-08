package com.projectFile.AutoStack.Controller;


import com.projectFile.AutoStack.Dto.Auth.AuthResponse;
import com.projectFile.AutoStack.Dto.Auth.Login;
import com.projectFile.AutoStack.Dto.Auth.SignUp;
import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;
import com.projectFile.AutoStack.Service.AuthService;
import com.projectFile.AutoStack.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

//    TODO:Auth Response need to create.

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> LoginReq(@RequestBody Login loginReq) throws AccessDeniedException {
        return ResponseEntity.ok(authService.login(loginReq));
    }

    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> SignUpReq( @RequestBody  SignUp signup) {
        return ResponseEntity.ok(authService.signUp(signup));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> ProfileReq() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));

    }


}
