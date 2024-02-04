package com.casefy.service.Modelo;

import java.util.List;

import com.casefy.dto.Modelo.*;

public interface ModeloService {
    public ModeloResponseDTO insert(ModeloDTO dto);

    public ModeloResponseDTO update(ModeloDTO dto, Long id);

    public void delete(Long id);

    public ModeloResponseDTO findById(Long id);

    public List<ModeloResponseDTO> findByNome(String nome);

    public List<ModeloResponseDTO> findByAll();
}
