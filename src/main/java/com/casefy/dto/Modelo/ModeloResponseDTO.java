package com.casefy.dto.Modelo;

import com.casefy.dto.Marca.MarcaResponseDTO;
import com.casefy.model.Modelo;

public record ModeloResponseDTO(
        Long id,
        String nome,
        MarcaResponseDTO idMarca) {

    //valueOf converte um objeto da classe modelo para um objeto ModeloResponseDTO. 
    public static ModeloResponseDTO valueOf(Modelo modelo) {
        return new ModeloResponseDTO(
                modelo.getId(),
                modelo.getNome(),
                MarcaResponseDTO.valueOf(modelo.getMarca())
        );
    }
}
