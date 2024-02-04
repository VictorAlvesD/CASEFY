package com.casefy.service.Cliente;

import java.util.List;

import com.casefy.dto.Cliente.*;

public interface ClienteService {

   public ClienteResponseDTO insert(ClienteDTO dto) throws Exception;

    public ClienteResponseDTO update(ClienteDTO dto, Long id);

    public void delete(Long id);

    public ClienteResponseDTO findById(Long id);

    public List<ClienteResponseDTO> findByNome(String nome);

    public List<ClienteResponseDTO> findByAll(); 
    
}
