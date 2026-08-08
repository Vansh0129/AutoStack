package com.projectFile.AutoStack.Security;

import com.projectFile.AutoStack.Entity.User;
import com.projectFile.AutoStack.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ContextUtil {
    private final UserRepo userRepo;

    public Long getId(){
     User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     return user.getId();
    }
    public User getContext(){
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

}
