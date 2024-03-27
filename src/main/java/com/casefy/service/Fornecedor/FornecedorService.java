package com.casefy.service.Fornecedor;

import java.util.List;

import com.casefy.dto.Fornecedor.FornecedorDTO;
import com.casefy.dto.Fornecedor.FornecedorResponseDTO;

public interface FornecedorService {

    public FornecedorResponseDTO insert(FornecedorDTO dto);

    public FornecedorResponseDTO update(FornecedorDTO dto, Long id);

    public void delete(Long id);

    public FornecedorResponseDTO findById(Long id);

    public List<FornecedorResponseDTO> findByNome(String nome);

    public List<FornecedorResponseDTO> findByAll();
}

