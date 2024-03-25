package com.casefy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Capinha extends DefaultEntity {

    @Column(length = 60)
    private String nome;

    @Column(length = 500)
    private String descricao;

    private Float valor;

    @Column(columnDefinition = "INTEGER CHECK (quantEstoque >= 0)")
    private Integer quantEstoque;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    @JsonBackReference
    private Modelo modelo;

    @ManyToOne
    private Marca marca;

    @Column
    @Enumerated(EnumType.STRING)
    private Cor cor;

    
    private String nomeImagem;
    
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(Integer quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

}
