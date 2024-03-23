package com.casefy.dto.Cidade;

import com.casefy.model.Cidade;

public record CidadeResponseDTO(
        Long id,
        String nome,
        String estado) {
    public static CidadeResponseDTO valueOf(Cidade novoCidade){
        return new CidadeResponseDTO(novoCidade.getId(), novoCidade.getNome(), novoCidade.getEstado().getNome());
    }
}
