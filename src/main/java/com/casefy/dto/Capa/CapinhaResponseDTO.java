package com.casefy.dto.Capa;

import com.casefy.model.Capinha;

import com.casefy.dto.Modelo.*;

public record CapinhaResponseDTO(
        Long id,
        String nome,
        ModeloResponseDTO modelo,
        Float valor,
        String descricao,
        String nomeImagem) {

    static public CapinhaResponseDTO valueOf(Capinha capinha) {
        return new CapinhaResponseDTO(
                capinha.getId(),
                capinha.getNome(),
                ModeloResponseDTO.valueOf(capinha.getModelo()),
                capinha.getValor(),
                capinha.getDescricao(),
                capinha.getNomeImagem()
        );
    }
}
