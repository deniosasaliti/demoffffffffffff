package com.example.demo.Entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Permissions implements GrantedAuthority {


    SAVE_OWN_POST,
    DELETE_OWN_POST,
    MODERATE_OWN_POST,
    SAVE_OWN_COMMENT,
    DELETE_OWN_COMMENT,
    MODERATE_OWN_COMMENT,
    BAN_USER,
    UNBAN_USER,
    MODERATE_POST,
    DELETE_POST,
    MODERATE_COMMENT,
    DELETE_COMMENT,
    CALL_THE_POLICE;


    @Override
    public String getAuthority() {
        return name();
    }
}
