package com.casefy.service.Pagamento;

import java.util.List;

import com.casefy.dto.Pagamento.*;

public interface PagamentoService {
    public PagamentoResponseDTO insert(PagamentoDTO dto, String login);

    public PagamentoResponseDTO update(PagamentoDTO dto, Long id);

    public void delete(Long id);

    public PagamentoResponseDTO findById(Long id);

    public List<PagamentoResponseDTO> findByTipo(String numero);

    public List<PagamentoResponseDTO> findByAll(); 

    public boolean pedidoJaPago(String login);
}
