package com.casefy.dto.Capa;

import com.casefy.model.Capinha;
import com.casefy.model.Cor;

import com.casefy.dto.Modelo.*;

public record CapinhaResponseDTO(
        Long id,
        String nome,
        ModeloResponseDTO modelo,
        Cor cor,
        Float valor,
        Integer quantEstoque,
        String descricao,
        String nomeImagem) {
    public CapinhaResponseDTO valueOf(Capinha capinha) {
        return new CapinhaResponseDTO(
                capinha.getId(),
                capinha.getNome(),
                new ModeloResponseDTO(capinha.getModelo()),
                cor,
                valor,
                quantEstoque,
                descricao,
                nomeImagem);
    }
}
