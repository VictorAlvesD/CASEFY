package com.casefy.dto.Lote;



import java.util.Date;

import com.casefy.dto.Fornecedor.FornecedorResponseDTO;
import com.casefy.model.Lote;

public record LoteResponseDTO(
    Long id,
    Long codigo,
    FornecedorResponseDTO fornecedor,
    Integer quantidadeItens,
    Float valorUnitario,
    Float valorTotal,
    Date dataCompra
) {
    static public LoteResponseDTO valueOf(Lote lote){
        return new LoteResponseDTO(
            lote.getId(),
            lote.getCodigo(),
            FornecedorResponseDTO.valueOf(lote.getFornecedor()),
            lote.getQuantidadeItens(),
            lote.getValorUnitario(),
            lote.getValorTotal(),
            lote.getDataCompra()
        );
    }
}
