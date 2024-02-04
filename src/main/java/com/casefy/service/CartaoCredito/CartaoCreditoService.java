package com.casefy.service.CartaoCredito;

import java.util.List;

import com.casefy.dto.CartaoCredito.*;

public interface CartaoCreditoService {
    public CartaoCreditoResponseDTO insert(CartaoCreditoDTO dto);

    public CartaoCreditoResponseDTO update(CartaoCreditoDTO dto, Long id);

    public void delete(Long id);

    public CartaoCreditoResponseDTO findById(Long id);

    public List<CartaoCreditoResponseDTO> findByBandeira(String bandeira);

    public List<CartaoCreditoResponseDTO> findByAll(); 
}
