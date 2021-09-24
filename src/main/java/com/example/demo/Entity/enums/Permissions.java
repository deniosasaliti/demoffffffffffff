package com.example.demo.Entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Permissions implements GrantedAuthority {
    CREATE_POST,
    DELETE_OWN_POST,
    MODERATE_OWN_POST,
    CREATE_COMMENT,
    DELETE_OWN_COMMENT,
    MODERATE_OWN_COMMENT,
    DELETE_POST,
    MODERATE_POST,
    DELETE_COMMENT,
    MODERATE_COMMENT,
    BAN_USER,
    UNBAN_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
