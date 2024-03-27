package com.casefy.model;

import java.util.List;

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

    @OneToMany(mappedBy = "marca")
    private List<Modelo> modelos;

    @OneToMany(mappedBy = "marca")
    private List<Capinha> capinhas;

    public String getNome() {
        return nome;
    }

    public List<Modelo> getModelo() {
        return modelos;
    }

    public void setModelo(List<Modelo> modelo) {
        this.modelos = modelo;
    }

    public List<Capinha> getCapinhas() {
        return capinhas;
    }

    public void setCapinhas(List<Capinha> capinhas) {
        this.capinhas = capinhas;
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
