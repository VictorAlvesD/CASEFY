package com.casefy.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 60)
    private String nome;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Modelo> modelos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public List<Modelo> getModelo() {
        return modelos;
    }

    public void setModelo(List<Modelo> modelo) {
        this.modelos = modelo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
