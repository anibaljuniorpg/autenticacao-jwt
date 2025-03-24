package com.anibal.autenticacao_jwt.controller;

import com.anibal.autenticacao_jwt.dtos.AuthRequestDTO;
import com.anibal.autenticacao_jwt.dtos.AuthResponseDTO;
import com.anibal.autenticacao_jwt.dtos.RegisterRequestDTO;
import com.anibal.autenticacao_jwt.service.TokenService;
import com.anibal.autenticacao_jwt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String teste(){
        return "Teste1";
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid AuthRequestDTO body){
        AuthResponseDTO user = this.userService.login(body);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody @Valid AuthRequestDTO body){
        AuthResponseDTO user = userService.register(body);
        return ResponseEntity.ok(user);
    }

}
