package com.projectFile.AutoStack.Controller;


import com.projectFile.AutoStack.Dto.Auth.AuthResponse;
import com.projectFile.AutoStack.Dto.Auth.Login;
import com.projectFile.AutoStack.Dto.Auth.SignUp;
import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;
import com.projectFile.AutoStack.Service.AuthService;
import com.projectFile.AutoStack.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> LoginReq(@RequestBody Login login){
        return null;
    }

    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> SignUpReq(@RequestBody SignUp login){
        return ResponseEntity.ok(authService.signUp(login));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> ProfileReq(){
        Long userId=1L;
        return ResponseEntity.ok(userService.getProfile(userId));




    }



}
