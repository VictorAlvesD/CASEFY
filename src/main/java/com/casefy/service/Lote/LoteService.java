package com.casefy.service.Lote;

import java.util.List;

import com.casefy.dto.Lote.LoteDTO;
import com.casefy.dto.Lote.LoteResponseDTO;

public interface LoteService {

    public LoteResponseDTO insert(LoteDTO dto);

    public LoteResponseDTO update(LoteDTO dto, Long id);

    public void delete(Long id);

    public LoteResponseDTO findById(Long id);

    public List<LoteResponseDTO> findByCodigo(Long cod);

    public List<LoteResponseDTO> findByAll();
}
