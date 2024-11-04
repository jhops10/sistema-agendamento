package com.jhops10.sistema_agendamento.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private int duracao;
    private BigDecimal valor;

    @ManyToOne
    private Usuario profissional;

    public Servico() {
    }

    public Servico(String nome, String descricao, int duracao, BigDecimal valor, Usuario profissional) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.valor = valor;
        this.profissional = profissional;
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Usuario getProfissional() {
        return profissional;
    }

    public void setProfissional(Usuario profissional) {
        this.profissional = profissional;
    }
}
