package com.jhops10.sistema_agendamento.controller;

import com.jhops10.sistema_agendamento.entity.Agendamento;
import com.jhops10.sistema_agendamento.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        var novoAgendamento = agendamentoService.criarAgendamento(agendamento);
        return ResponseEntity.ok(novoAgendamento);
    }

    @GetMapping("/profissional/{id}")
    public ResponseEntity<List<Agendamento>> listarAgendamentosPorProfissional(@PathVariable("id") Long id) {
        var agendamentos = agendamentoService.listarAgendamentosPorProfissional(id);
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Agendamento>> listarAgendamentosPorCliente(@PathVariable("id") Long id) {
        var agendamentos = agendamentoService.listarAgendamentosPorCliente(id);
        return ResponseEntity.ok(agendamentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }


}
