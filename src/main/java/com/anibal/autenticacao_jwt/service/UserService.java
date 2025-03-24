package com.anibal.autenticacao_jwt.service;

import com.anibal.autenticacao_jwt.configuration.SecurityConfiguration;
import com.anibal.autenticacao_jwt.dtos.AuthRequestDTO;
import com.anibal.autenticacao_jwt.dtos.AuthResponseDTO;
import com.anibal.autenticacao_jwt.dtos.RegisterRequestDTO;
import com.anibal.autenticacao_jwt.entity.User;
import com.anibal.autenticacao_jwt.entity.UserRole;
import com.anibal.autenticacao_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private  TokenService tokenService;
    @Autowired
    private SecurityConfiguration securityConfiguration;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public AuthResponseDTO login(AuthRequestDTO requestDTO){
        User user = this.repository.findByLogin(requestDTO.login()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(requestDTO.password(), user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return new AuthResponseDTO(user.getUsername(), token);
        }
        throw  new RuntimeException("User not found");
    }

    public AuthResponseDTO register(AuthRequestDTO requestDTO){
        Optional<User> user = this.repository.findByLogin(requestDTO.login());
        if (user.isEmpty()){
            UserRole role = UserRole.USER;
            User newUser = new User(requestDTO.login(), passwordEncoder.encode(requestDTO.password()), role);
            this.repository.save(newUser);
            String token = this.tokenService.generateToken(newUser);
            return new AuthResponseDTO(newUser.getUsername(), token);
        }
        throw  new RuntimeException("User existing");
    }

}
