package com.anibal.autenticacao_jwt.dtos;

import com.anibal.autenticacao_jwt.entity.UserRole;

public record RegisterRequestDTO(String login, String password, UserRole role) {
}
