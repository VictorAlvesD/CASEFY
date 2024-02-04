package com.casefy.service.BoletoBancario;

import java.util.List;

import com.casefy.dto.BoletoBancario.*;


public interface BoletoBancarioService {
    public BoletoBancarioResponseDTO insert(BoletoBancarioDTO dto);

    public BoletoBancarioResponseDTO update(BoletoBancarioDTO dto, Long id);

    public void delete(Long id);

    public BoletoBancarioResponseDTO findById(Long id);

    public List<BoletoBancarioResponseDTO> findByNumeroBoleto(String numero);

    public List<BoletoBancarioResponseDTO> findByAll(); 
}
