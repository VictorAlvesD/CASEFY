package com.casefy.dto;

import com.casefy.model.Pagamento;
import com.casefy.model.StatusPagamento;

public record PagamentoResponseDTO(
        Long id,
        String tipo,
        Double valor,
        PedidoResponseDTO pedidoDTO,
        StatusPagamento statusPagamento) {
    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {
        return new PagamentoResponseDTO(
                pagamento.getId(),
                pagamento.getTipo(),
                pagamento.getValor(),
                PedidoResponseDTO.valueOf(pagamento.getPedido()),
                pagamento.getStatusPagamento());
    }
}