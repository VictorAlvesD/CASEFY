package com.casefy.service.Marca;

import java.util.List;

import com.casefy.dto.Marca.MarcaDTO;
import com.casefy.dto.Marca.MarcaResponseDTO;

public interface MarcaService {
    public MarcaResponseDTO insert(MarcaDTO dto);

    public MarcaResponseDTO update(MarcaDTO dto, Long id);

    public void delete(Long id);

    public MarcaResponseDTO findById(Long id);

    public List<MarcaResponseDTO> findByNome(String nome);

    public List<MarcaResponseDTO> findByAll(int page, int PageSize);

    public long count();

}
