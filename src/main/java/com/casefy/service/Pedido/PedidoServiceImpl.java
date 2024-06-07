package com.casefy.service.Pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.casefy.dto.*;
import com.casefy.dto.ItemVenda.ItemVendaDTO;
import com.casefy.dto.ItemVenda.ItemVendaResponseDTO;
import com.casefy.dto.Pedido.PedidoDTO;
import com.casefy.dto.Pedido.PedidoResponseDTO;
import com.casefy.model.Cidade;
import com.casefy.model.Cliente;
import com.casefy.model.Endereco;
import com.casefy.model.Estado;
import com.casefy.model.ItemVenda;
import com.casefy.model.Pedido;
import com.casefy.repository.ClienteRepository;
import com.casefy.repository.EnderecoRepository;
import com.casefy.repository.ItemVendaRepository;
import com.casefy.repository.PedidoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    ItemVendaRepository itemVendaRepository;

    @Inject
    ClienteRepository clienteRepository;

    @Override
    public PedidoResponseDTO insert(PedidoDTO dto, String login) {
        Pedido pedido = new Pedido();
        pedido.setDataHora(LocalDateTime.now());

        Double total = 0.0;
        for (ItemVendaDTO itemDTO : dto.itens()) {
            total += (itemDTO.valor() * itemDTO.quantidade());
        }
        pedido.setValorTotal(total);

        pedido.setItens(dto.itens().stream()
                .map(this::createItemVenda)
                .collect(Collectors.toList()));

        
        Endereco endereco = enderecoRepository.findById(dto.endereco().cidade());
        pedido.setEndereco(endereco);

        pedido.setCliente((Cliente) clienteRepository.findByLogin(login));

        pedidoRepository.persist(pedido);

        return PedidoResponseDTO.valueOf(pedido);
    }

    private ItemVenda createItemVenda(ItemVendaDTO itemDTO) {
        ItemVenda item = new ItemVenda();
        item.setValor(itemDTO.valor());
        item.setQuantidade(itemDTO.quantidade());
        // Defina outras propriedades do item de venda conforme necessário
        return item;
    }

    @Override
    public void delete(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido == null) {
            throw new NotFoundException("Pedido não encontrado");
        }

        pedidoRepository.delete(pedido);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido == null) {
            throw new NotFoundException("Pedido não encontrado");
        }

        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return pedidoRepository.listAll().stream()
                .map(PedidoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDTO> findByAll(String login) {
        // Implemente a lógica para retornar todos os pedidos de um cliente específico
        return new ArrayList<>();
    }

    @Override
    public List<PedidoResponseDTO> pedidosUsuarioLogado(Cliente cliente) {
        // Implemente a lógica para retornar todos os pedidos de um cliente logado
        return new ArrayList<>();
    }

    @Override
    public List<ItemVendaResponseDTO> findItensByUsuario(Cliente cliente) {
        // Implemente a lógica para retornar todos os itens de venda de um cliente
        // específico
        return new ArrayList<>();
    }

}
