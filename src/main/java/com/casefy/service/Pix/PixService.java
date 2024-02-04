package com.casefy.service.Pix;

import java.util.List;

import com.casefy.dto.Pix.*;

public interface PixService {
    public PixResponseDTO insert(PixDTO dto);

    public PixResponseDTO update(PixDTO dto, Long id);

    public void delete(Long id);

    public PixResponseDTO findById(Long id);

    public List<PixResponseDTO> findByChave(String numero);

    public List<PixResponseDTO> findByAll(); 
}
