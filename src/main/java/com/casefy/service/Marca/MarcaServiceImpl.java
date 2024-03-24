package com.casefy.service.Marca;

import java.util.List;

import com.casefy.dto.Marca.MarcaDTO;
import com.casefy.dto.Marca.MarcaResponseDTO;
import com.casefy.model.Marca;
import com.casefy.repository.MarcaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService {

    @Inject
    MarcaRepository marcaRepository;

    @Override
    @Transactional
    public MarcaResponseDTO insert(MarcaDTO dto) {
        Marca novaMarca = new Marca();

        novaMarca.setNome(dto.nome());
        marcaRepository.persist(novaMarca);

        return new MarcaResponseDTO(novaMarca);
    }

    @Override
    @Transactional
    public MarcaResponseDTO update(MarcaDTO dto, Long id) {
        Marca marcaExistente = marcaRepository.findById(id);
        if (marcaExistente == null) {
            throw new EntityNotFoundException("Marca com ID " + id + " não encontrada");
        }
        marcaExistente.setNome(dto.nome());
        
        marcaRepository.persist(marcaExistente);
        return new MarcaResponseDTO(marcaExistente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!marcaRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public MarcaResponseDTO findById(Long id) {
        Marca marca = marcaRepository.findById(id);
        if (marca == null) {
            throw new EntityNotFoundException("Marca não encontrada com ID: " + id);
        }
        return new MarcaResponseDTO(marca);
    }

    @Override
    public List<MarcaResponseDTO> findByNome(String nome) {
        return marcaRepository.findByNome(nome).stream()
                .map(e -> new MarcaResponseDTO(e)).toList();
    }

    @Override
    public List<MarcaResponseDTO> findByAll() {
        return marcaRepository.listAll().stream()
                .map(e -> new MarcaResponseDTO(e)).toList();
    }

}
