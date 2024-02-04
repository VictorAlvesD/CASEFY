package com.casefy.service.Estado;

import java.util.List;

import com.casefy.dto.Estado.*;

public interface EstadoService {
    public EstadoResponseDTO insert(EstadoDTO dto);

    public EstadoResponseDTO update(EstadoDTO dto, Long id);

    public void delete(Long id);

    public EstadoResponseDTO findById(Long id);

    public List<EstadoResponseDTO> findByNome(String nome);

    public List<EstadoResponseDTO> findByAll(); 
}
