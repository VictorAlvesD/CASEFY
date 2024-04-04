package com.casefy.service.Promocao;

import java.util.List;

import com.casefy.dto.Promocao.*;
import com.casefy.model.Promocao;
import com.casefy.repository.PromocaoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PromocaoServiceImpl implements PromocaoService {

    @Inject
    PromocaoRepository repository;

    @Override
    @Transactional
    public PromocaoResponseDTO insert(PromocaoDTO dto) {
        Promocao novoPromocao = new Promocao();
        novoPromocao.setCodigo(dto.codigo());
        novoPromocao.setDescricao(dto.descricao());
        novoPromocao.setValorDesconto(dto.valorDesconto());

        repository.persist(novoPromocao);

        return PromocaoResponseDTO.valueOf(novoPromocao);
    }

    @Override
    @Transactional
    public PromocaoResponseDTO update(PromocaoDTO dto, Long id) {

        Promocao atualizarPromocao = repository.findById(id);

        atualizarPromocao.setCodigo(dto.codigo());
        atualizarPromocao.setDescricao(dto.descricao());
        atualizarPromocao.setValorDesconto(dto.valorDesconto());

        return PromocaoResponseDTO.valueOf(atualizarPromocao);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PromocaoResponseDTO findById(Long id) {
        Promocao tell = repository.findById(id);
        if (tell == null) {
            throw new EntityNotFoundException("Promocao não encontrado com ID: " + id);
        }
        return PromocaoResponseDTO.valueOf(tell);
    }

    @Override
    public List<PromocaoResponseDTO> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo).stream()
                .map(e -> PromocaoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PromocaoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PromocaoResponseDTO.valueOf(e)).toList();
    }

}
