package com.example.demo.Entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Permissions implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
