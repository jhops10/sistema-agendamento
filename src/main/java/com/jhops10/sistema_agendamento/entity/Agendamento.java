package com.jhops10.sistema_agendamento.entity;

import com.jhops10.sistema_agendamento.entity.enums.StatusAgendamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "O cliente é obrigatório.")
    private Usuario cliente;


    @ManyToOne
    @NotNull(message = "O Serviço é obrigatório.")
    private Servico servico;

    @NotNull(message = "O id do profisisonal é obrigatório.")
    private Long profissionalId;

    @NotNull(message = "A data e hora do agendamento são obrigatórias.")
    @Future(message = "A data e hora do agendamento devem estar no futuro.")
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O status do agendamento é obrigatório")
    private StatusAgendamento status;

    public Agendamento() {
    }

    public Agendamento(Usuario cliente, Servico servico, LocalDateTime dataHora, StatusAgendamento status) {
        this.cliente = cliente;
        this.servico = servico;
        this.dataHora = dataHora;
        this.status = status;
    }

    public Long getId() {
        return id;
    }


    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
}
