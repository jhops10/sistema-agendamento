package com.jhops10.sistema_agendamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desativa o CSRF usando lambda
                .authorizeRequests(auth -> auth
                        // Permitir acesso público para os endpoints de autenticação
                        .requestMatchers("/auth/register", "/auth/login").permitAll()
                        // Somente CLIENTES e PROFISSIONAIS podem acessar o sistema de agendamento
                        .requestMatchers("/agendamento/**").hasAnyRole("CLIENTE", "PROFISSIONAL")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form   // Configuração de login via formulário
                        .loginPage("/auth/login")  // Página de login personalizada
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Para encriptar senhas
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.build();
    }

}
