package com.anibal.autenticacao_jwt.dtos;

import com.anibal.autenticacao_jwt.entity.User;
import com.anibal.autenticacao_jwt.entity.UserRole;
import lombok.Builder;

import java.util.Optional;

public record AuthResponseDTO(String login, String token) {

}
