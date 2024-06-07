package com.casefy.model;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoPagamento {
    
    PIX(1, "Pix"),
    BOLETO_BANCARIO(2, "Boleto Bancario"),
    CARTAO_CREDITO(3, "Cartão de Crédito");

    private final Integer id;
    private final String label;

    TipoPagamento(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoPagamento valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (TipoPagamento status : TipoPagamento.values()) {
            if (status.getId().equals(id))
                return status;
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }
}
