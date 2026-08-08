package com.projectFile.AutoStack.Security;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public record JwtUserPrincipal(Long id, String email , List<GrantedAuthority> authority) {
}
