package com.casefy.dto.Capa;

import com.casefy.model.Capinha;

import com.casefy.dto.Modelo.*;

public record CapinhaResponseDTO(
        Long id,
        String nome,
        String descricao,
        ModeloResponseDTO modelo,
        Float valor,
        String imagem) {

    static public CapinhaResponseDTO valueOf(Capinha capinha) {
        return new CapinhaResponseDTO(
                capinha.getId(),
                capinha.getNome(),
                capinha.getDescricao(),
                ModeloResponseDTO.valueOf(capinha.getModelo()),
                capinha.getValor()
                , capinha.getNomeImagem());
    }
}
