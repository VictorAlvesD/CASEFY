package com.casefy.dto.Pedido;

import java.time.LocalDateTime;
import java.util.List;

import com.casefy.dto.Cliente.ClienteResponseDTO;
import com.casefy.dto.Endereco.EnderecoResponseDTO;
import com.casefy.dto.ItemVenda.ItemVendaResponseDTO;
import com.casefy.model.Pedido;

public record PedidoResponseDTO(
        Long id,
        LocalDateTime horario,
        ClienteResponseDTO usuario,
        Double valorTotal,
        List<ItemVendaResponseDTO> itens,
        EnderecoResponseDTO endereco) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getDataHora(),
                ClienteResponseDTO.valueOf(pedido.getCliente()),
                pedido.getValorTotal(),
                ItemVendaResponseDTO.valueOf(pedido.getItens()),
                EnderecoResponseDTO.valueOf(pedido.getEndereco()));
    }
}
