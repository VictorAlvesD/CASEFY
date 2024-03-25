package com.casefy.dto.Cidade;

import com.casefy.dto.Estado.EstadoResponseDTO;
import com.casefy.model.Cidade;

public record CidadeResponseDTO(
        Long id,
        String nome,
        EstadoResponseDTO estado) {
    public static CidadeResponseDTO valueOf(Cidade novoCidade){
        return new CidadeResponseDTO(
            novoCidade.getId(), 
            novoCidade.getNome(), 
            EstadoResponseDTO.valueOf(novoCidade.getEstado())
            );
    }
}
