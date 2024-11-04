package com.jhops10.sistema_agendamento.entity;

import com.jhops10.sistema_agendamento.entity.enums.StatusNotificacao;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario destinatario;

    private String conteudo;
    private LocalDateTime dataEnvio;

    @Enumerated(EnumType.STRING)
    private StatusNotificacao status;

    public Notificacao() {
    }

    public Notificacao(Usuario destinatario, String conteudo, LocalDateTime dataEnvio, StatusNotificacao status) {
        this.destinatario = destinatario;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.status = status;
    }

    public Long getId() {
        return id;
    }


    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public StatusNotificacao getStatus() {
        return status;
    }

    public void setStatus(StatusNotificacao status) {
        this.status = status;
    }
}
