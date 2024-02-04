package com.casefy.dto.Pagamento;

import java.util.List;
import com.casefy.dto.Pix.*;
import com.casefy.dto.BoletoBancario.*;
import com.casefy.dto.CartaoCredito.*;
import jakarta.validation.constraints.NotBlank;

public record PagamentoDTO(
        @NotBlank(message = "O campo tipo não pode ser nulo") String tipo,
        List<PixDTO> pix,
        List<BoletoBancarioDTO> boletoBancario,
        List<CartaoCreditoDTO> cartaoCredito) {
}