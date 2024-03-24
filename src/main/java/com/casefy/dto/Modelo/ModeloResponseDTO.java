package com.casefy.dto.Modelo;

import com.casefy.dto.Marca.MarcaResponseDTO;
import com.casefy.model.Modelo;

public record ModeloResponseDTO(
        Long id,
        String nome,
        MarcaResponseDTO idMarca) {

    public ModeloResponseDTO(Modelo modelo) {
        this(
                modelo.getId(),
                modelo.getNome(),
                new MarcaResponseDTO(modelo.getMarca()));
    }
}
