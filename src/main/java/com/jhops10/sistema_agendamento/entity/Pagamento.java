package com.jhops10.sistema_agendamento.entity;

import com.jhops10.sistema_agendamento.entity.enums.StatusPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Agendamento agendamento;

    private BigDecimal valor;
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    public Pagamento() {
    }

    public Pagamento(Agendamento agendamento, BigDecimal valor, LocalDateTime data, StatusPagamento status) {
        this.agendamento = agendamento;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public Long getId() {
        return id;
    }


    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }
}
