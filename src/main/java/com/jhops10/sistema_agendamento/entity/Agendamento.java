package com.jhops10.sistema_agendamento.entity;

import com.jhops10.sistema_agendamento.entity.enums.StatusAgendamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario cliente;

    @ManyToOne
    private Servico servico;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
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
