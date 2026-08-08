package com.projectFile.AutoStack.Security;

import com.projectFile.AutoStack.Entity.User;
import com.projectFile.AutoStack.Service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    //kind of decoration pattern it follows
    private final UserService userService;
    private  final AuthUtil authUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestHeadertoken = request.getHeader("Authorization");
        log.info(" Header token" + requestHeadertoken);
        if (requestHeadertoken == null || !requestHeadertoken.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;     //this break the chain .
        }

        String token = requestHeadertoken.split("Bearer")[1].trim();
//        Extracting the Actual User Value if token is valid.
        JwtUserPrincipal userPrincipal=authUtil.VerifyAccessToken(token);
        if(userPrincipal ==null || SecurityContextHolder.getContext().getAuthentication()==null) {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.authority());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        //Passing security context in auth

        filterChain.doFilter(request,response);


    }  //set filterChange and move to next filter!

}
