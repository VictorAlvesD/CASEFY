package com.casefy.dto.Pagamento;

import java.util.List;
import com.casefy.dto.Pix.*;
import com.casefy.dto.BoletoBancario.*;
import com.casefy.dto.CartaoCredito.*;

public record PagamentoDTO(
        String tipo,
        List<PixDTO> pix,
        List<BoletoBancarioDTO> boletoBancario,
        List<CartaoCreditoDTO> cartaoCredito) {
}