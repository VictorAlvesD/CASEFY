package com.casefy.dto.Pedido;

import java.util.List;
import com.casefy.dto.ItemVenda.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoDTO (
    @NotNull(message = "O campo endereco não pode ser nulo")
    Long idEndereco,
    @NotBlank(message = "O campo itens de venda não pode ser nulo")
    List<ItemVendaDTO> itens
) {
    
}
