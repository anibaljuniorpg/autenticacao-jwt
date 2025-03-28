package com.anibal.autenticacao_jwt.entity;

public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String role;
    UserRole(String role){
        this.role=role;
    }
    public String getRole(){
        return role;
    }
}
