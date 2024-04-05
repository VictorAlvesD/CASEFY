package com.casefy.dto.Promocao;

import com.casefy.model.Promocao;

public record PromocaoResponseDTO(
        Long id,
        String codigo,
        String descricao,
        Float valorDesconto) {
    public static PromocaoResponseDTO valueOf(Promocao promocao) {
        return new PromocaoResponseDTO(
            promocao.getId(),
            promocao.getCodigo(),
            promocao.getDescricao(),
            promocao.getValorDesconto()
        );
    }
}
