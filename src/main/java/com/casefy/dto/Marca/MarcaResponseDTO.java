package com.casefy.dto.Marca;

import com.casefy.model.Marca;

public record MarcaResponseDTO(
        Long id,
        String nome) {

    public MarcaResponseDTO(Marca marca) {
        this(marca.getId(), marca.getNome());
    }
}