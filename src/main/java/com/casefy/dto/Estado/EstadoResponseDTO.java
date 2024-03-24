package com.casefy.dto.Estado;

import com.casefy.model.Estado;

public record EstadoResponseDTO(
        Integer id,
        String nome,
        String sigla) {

    public static EstadoResponseDTO valueOf(Estado estado) {
        return new EstadoResponseDTO(
                estado.getId(),
                estado.getNome(),
                estado.getSigla());
    }
}