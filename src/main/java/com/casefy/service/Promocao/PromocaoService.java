package com.casefy.service.Promocao;

import java.util.List;

import com.casefy.dto.Promocao.*;

public interface PromocaoService {

    public PromocaoResponseDTO insert(PromocaoDTO dto);

    public PromocaoResponseDTO update(PromocaoDTO dto, Long id);

    public void delete(Long id);

    public PromocaoResponseDTO findById(Long id);

    public List<PromocaoResponseDTO> findByCodigo(String codigo);

    public List<PromocaoResponseDTO> findByAll(); 
    
}