package com.casefy.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NivelAcesso {
    
    ANALISTA(1, "Analista"),
    SUPERVISOR(2, "Supervisor"),
    GERENTE(3, "Gerente");

    private final Integer id;
    private final String label;

    NivelAcesso(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static NivelAcesso valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (NivelAcesso nivel : NivelAcesso.values()) {
            if (nivel.getId().equals(id))
                return nivel;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }
}
