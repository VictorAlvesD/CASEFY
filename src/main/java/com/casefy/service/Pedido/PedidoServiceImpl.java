package com.casefy.service.Pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.casefy.dto.ItemVenda.*;
import com.casefy.dto.Pedido.*;
import com.casefy.model.Capinha;
import com.casefy.model.Cliente;
import com.casefy.model.Endereco;
import com.casefy.model.ItemVenda;
import com.casefy.model.Pedido;
import com.casefy.repository.CapinhaRepository;
import com.casefy.repository.ClienteRepository;
import com.casefy.repository.EnderecoRepository;
import com.casefy.repository.ItemVendaRepository;
import com.casefy.repository.PagamentoRepository;
import com.casefy.repository.PedidoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {
    @Inject
    CapinhaRepository capinhaRepository;

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    ItemVendaRepository itemVendaRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    PagamentoRepository pagamentoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto, String login) {
        Pedido pedido = new Pedido();
        pedido.setDataHora(LocalDateTime.now());

        Double total = 0.0;
        for (ItemVendaDTO itemDTO : dto.itens()) {
            total += (itemDTO.valor() * itemDTO.quantidade());
        }
        pedido.setValorTotal(total);

        pedido.setItens(new ArrayList<ItemVenda>());
        for (ItemVendaDTO itemDTO : dto.itens()) {
            ItemVenda item = new ItemVenda();
            item.setValor(itemDTO.valor());
            item.setQuantidade(itemDTO.quantidade());
            item.setPedido(pedido);
            Capinha capinha = capinhaRepository.findById(itemDTO.idCapinha());
            if (capinha == null) {
                throw new IllegalArgumentException("Não existe essa capa de celular!");
            }
            item.setCapinha(capinha);

            pedido.getItens().add(item);
        }
        
        Endereco endereco = enderecoRepository.findById(dto.idEndereco());
        pedido.setEndereco(endereco);

        pedido.setCliente((Cliente) clienteRepository.findByLogin(login));

        pedidoRepository.persist(pedido);

        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(pedidoRepository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return pedidoRepository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByAll(String login) {
        return pedidoRepository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public void delete(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido == null) {
            throw new NotFoundException();
        }

        for (ItemVenda item : pedido.getItens()) {
            itemVendaRepository.delete(item);
        }

        pedidoRepository.delete(pedido);
    }

    @Override
    public List<PedidoResponseDTO> pedidosUsuarioLogado(Cliente cliente) {
        Cliente usuario = clienteRepository.findByLogin(cliente.getLogin());
        List<Pedido> pedidos = pedidoRepository.findByUsuario(usuario);
        return pedidos.stream().map(p -> PedidoResponseDTO.valueOf(p)).collect(Collectors.toList());
    }

    public List<ItemVendaResponseDTO> findItensByUsuario(Cliente cliente) {
        List<Pedido> pedidos = pedidoRepository.findByUsuario(cliente);
        List<ItemVenda> itens = new ArrayList<>();
    
        for (Pedido pedido : pedidos) {
            itens.addAll(pedido.getItens());
        }
    
        return itens.stream()
                .map(i -> ItemVendaResponseDTO.valueOf(i))
                .collect(Collectors.toList());
    }
}
