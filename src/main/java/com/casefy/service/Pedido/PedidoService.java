package com.casefy.service;

import java.util.List;

import com.casefy.dto.ItemVendaResponseDTO;
import com.casefy.dto.PedidoDTO;
import com.casefy.dto.PedidoResponseDTO;
import com.casefy.model.Cliente;

public interface PedidoService {
    public PedidoResponseDTO insert(PedidoDTO dto, String login);

    public void delete(Long id);

    public PedidoResponseDTO findById(Long id);

    public List<PedidoResponseDTO> findByAll();

    public List<PedidoResponseDTO> findByAll(String login);

    public List<PedidoResponseDTO> pedidosUsuarioLogado(Cliente cliente);

    public List<ItemVendaResponseDTO> findItensByUsuario(Cliente cliente);
}
