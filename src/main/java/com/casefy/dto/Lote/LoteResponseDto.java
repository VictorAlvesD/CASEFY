package com.casefy.dto.Lote;

import java.sql.Date;

import com.casefy.dto.Fornecedor.FornecedorResponseDTO;
import com.casefy.model.Lote;

public record LoteResponseDto(
    FornecedorResponseDTO fornecedor,
    Integer quantidadeItens,
    Float valorUnitario,
    Float valorTotal,
    Date dataCompra
) {
    static public LoteResponseDto valueOf(Lote lote){
        return new LoteResponseDto(
            FornecedorResponseDTO.valueOf(lote.getFornecedor()),
            lote.getQuantidadeItens(),
            lote.getValorUnitario(),
            lote.getValorTotal(),
            lote.getDataCompra()
        );
    }
}
