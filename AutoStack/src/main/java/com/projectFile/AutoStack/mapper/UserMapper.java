package com.projectFile.AutoStack.mapper;

import com.projectFile.AutoStack.Dto.Auth.AuthResponse;
import com.projectFile.AutoStack.Dto.Auth.SignUp;
import com.projectFile.AutoStack.Dto.Auth.UserProfileResponse;
import com.projectFile.AutoStack.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserProfileResponse toUserProfileResponseFromUser(User user);
    @Mapping(target="id",source = "user.id")
    @Mapping(target="email",source = "user.email")
    @Mapping(target="name",source = "user.name")
    AuthResponse toAuthResponseFromUserAccess(String accessToken,User user);

    User toUserFromSignUp(SignUp signUp);
}
