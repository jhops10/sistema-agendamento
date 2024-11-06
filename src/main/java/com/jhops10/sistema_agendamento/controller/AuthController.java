package com.jhops10.sistema_agendamento.controller;

import com.jhops10.sistema_agendamento.entity.Usuario;
import com.jhops10.sistema_agendamento.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        var novoUsuario = usuarioService.registerUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        var usuarioExistente = usuarioService.findByEmail(usuario.getEmail());

        if (usuarioExistente != null && usuarioService.passwordEncoder.matches(usuario.getSenha(), usuarioExistente.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido!");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }



}
