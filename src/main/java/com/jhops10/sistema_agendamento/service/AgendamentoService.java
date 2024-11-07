package com.jhops10.sistema_agendamento.service;

import com.jhops10.sistema_agendamento.entity.Agendamento;
import com.jhops10.sistema_agendamento.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public Agendamento criarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarAgendamentosPorProfissional(Long profissionalId) {
        return agendamentoRepository.findByProfissionalId(profissionalId);
    }

    public List<Agendamento> listarAgendamentosPorCliente(Long clienteId) {
        return agendamentoRepository.findByProfissionalId(clienteId);
    }

    public Optional<Agendamento> buscarAgendamento(Long id) {
        return agendamentoRepository.findById(id);
    }

    public void deletarAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
