package com.jhops10.sistema_agendamento.repository;

import com.jhops10.sistema_agendamento.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByProfissionalId(Long profissionalId);
    List<Agendamento> findByClienteId(Long clienteId);
}
