package com.casefy.service.Telefone;

import java.util.List;

import com.casefy.dto.Telefone.*;

public interface TelefoneService {

    public TelefoneResponseDTO insert(TelefoneDTO dto);

    public TelefoneResponseDTO update(TelefoneDTO dto, Long id);

    public void delete(Long id);

    public TelefoneResponseDTO findById(Long id);

    public List<TelefoneResponseDTO> findByNumero(String numero);

    public List<TelefoneResponseDTO> findByAll(); 
    
}
