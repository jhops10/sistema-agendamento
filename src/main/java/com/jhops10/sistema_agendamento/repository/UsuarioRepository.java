package com.jhops10.sistema_agendamento.repository;

import com.jhops10.sistema_agendamento.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByEmail(String email);
}
