package com.casefy.dto.Lote;

import java.sql.Date;

import com.casefy.dto.Fornecedor.FornecedorResponseDTO;
import com.casefy.model.Lote;

public record LoteResponseDTO(
    FornecedorResponseDTO fornecedor,
    Integer quantidadeItens,
    Float valorUnitario,
    Float valorTotal,
    Date dataCompra
) {
    static public LoteResponseDTO valueOf(Lote lote){
        return new LoteResponseDTO(
            FornecedorResponseDTO.valueOf(lote.getFornecedor()),
            lote.getQuantidadeItens(),
            lote.getValorUnitario(),
            lote.getValorTotal(),
            lote.getDataCompra()
        );
    }
}
