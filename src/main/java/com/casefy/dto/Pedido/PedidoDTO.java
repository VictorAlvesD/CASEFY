package com.casefy.dto.Pedido;

import java.util.List;

import com.casefy.dto.BoletoBancario.BoletoBancarioDTO;
import com.casefy.dto.CartaoCredito.CartaoCreditoDTO;
import com.casefy.dto.Endereco.EnderecoDTO;
import com.casefy.dto.ItemVenda.*;
import com.casefy.dto.Pix.PixDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoDTO (
    EnderecoDTO endereco,
    
    @NotBlank(message = "O campo itens de venda não pode ser nulo")
    List<ItemVendaDTO> itens,
    
    Long idCliente,
    
    // Tipo de pagamento: 1 - Pix, 2 - Boleto Bancário, 3 - Cartão de Crédito
    @Min(value = 1, message = "Tipo de pagamento inválido")
    @Max(value = 3, message = "Tipo de pagamento inválido")
    Integer tipoPagamento,
    
    // Informações do pagamento por cartão de crédito
    CartaoCreditoDTO cartaoCredito,
    
    // Informações do pagamento por Pix
    PixDTO pix
    
) {
    
}
