package com.casefy.dto.Cidade;

import com.casefy.model.Cidade;

public record CidadeResponseDTO(
        Long id,
        String nome,
        String estado) {
    public static CidadeResponseDTO valueOf(Cidade cidade){
        return new CidadeResponseDTO(cidade.getId(), cidade.getNome(), cidade.getEstado().getNome());
    }
}
