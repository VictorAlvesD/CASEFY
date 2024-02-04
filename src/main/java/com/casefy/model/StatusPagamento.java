package com.casefy.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusPagamento {

    PENDENTE(1, "Pendente"),
    APROVADO(2, "Aprovado"),
    REJEITADO(3, "Rejeitado"),
    CANCELADO(4, "Cancelado");

    private final Integer id;
    private final String label;

    StatusPagamento(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static StatusPagamento valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (StatusPagamento status : StatusPagamento.values()) {
            if (status.getId().equals(id))
                return status;
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }
}
