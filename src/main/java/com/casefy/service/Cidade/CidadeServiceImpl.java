package com.casefy.service.Cidade;

import java.util.List;

import com.casefy.dto.Cidade.*;
import com.casefy.model.Cidade;
import com.casefy.model.Estado;
import com.casefy.repository.CidadeRepository;
import com.casefy.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {
    @Inject
    CidadeRepository repository;

    @Inject
    EstadoRepository estadoRepository;

    @Override
    @Transactional
    public CidadeResponseDTO insert(CidadeDTO dto) {

        var novacidade = new Cidade();
        novacidade.setNome(dto.nome());
        novacidade.setEstado(dto.estado());

        repository.persist(novacidade);

        return CidadeResponseDTO.valueOf(novacidade);
    }

    @Override
    @Transactional
    public CidadeResponseDTO update(CidadeDTO dto, Long id) {

        Cidade cidadeExistente = repository.findById(id);
        if (cidadeExistente == null) {
            throw new EntityNotFoundException("Cidade com ID " + id + " não encontrada");
        }
        cidadeExistente.setNome(dto.nome());
        cidadeExistente.setEstado(dto.estado());

        repository.persist(cidadeExistente);
        return CidadeResponseDTO.valueOf(cidadeExistente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public CidadeResponseDTO findById(Long id) {
        Cidade cidade = repository.findById(id);
        if (cidade == null) {
            throw new EntityNotFoundException("Cidade não encontrado com ID: " + id);
        }
        return CidadeResponseDTO.valueOf(cidade);
    }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CidadeResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }

}