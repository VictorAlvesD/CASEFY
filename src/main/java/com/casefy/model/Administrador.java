package com.casefy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrador extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 5)
    private Integer matricula;
    @Column(length = 16)
    private String cpf;
    private NivelAcesso nivelAcesso;

    

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
