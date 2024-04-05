package com.casefy.service.Modelo;

import java.util.List;

import com.casefy.dto.Modelo.*;
import com.casefy.model.Marca;
import com.casefy.model.Modelo;
import com.casefy.repository.MarcaRepository;
import com.casefy.repository.ModeloRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ModeloServiceImpl implements ModeloService {
    @Inject
    ModeloRepository modeloRepository;

    @Inject
    MarcaRepository marcaRepository;

    @Override
    @Transactional
    public ModeloResponseDTO insert(ModeloDTO modeloDTO) {

        Modelo novoModelo = new Modelo();
        novoModelo.setNome(modeloDTO.nome());
        novoModelo.setMarca(modeloDTO.marca());

        modeloRepository.persist(novoModelo);

        return ModeloResponseDTO.valueOf(novoModelo);
    }

    @Override
    @Transactional
    public ModeloResponseDTO update(ModeloDTO dto, Long id) {

        Modelo modeloExistente = modeloRepository.findById(id);
        if (modeloExistente == null) {
            throw new EntityNotFoundException("Modelo com ID " + id + " não encontrada");
        }
        modeloExistente.setNome(dto.nome());
        modeloExistente.setMarca(dto.marca());

        modeloRepository.persist(modeloExistente);
        return ModeloResponseDTO.valueOf(modeloExistente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!modeloRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public ModeloResponseDTO findById(Long id) {
        Modelo modelo = modeloRepository.findById(id);
        if (modelo == null) {
            throw new EntityNotFoundException("Modelo não encontrado com ID: " + id);
        }
        return ModeloResponseDTO.valueOf(modelo);
    }

    @Override
    public List<ModeloResponseDTO> findByNome(String nome) {
        return modeloRepository.findByNome(nome).stream()
                .map(e ->  ModeloResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ModeloResponseDTO> findByAll() {
        return modeloRepository.listAll().stream()
                .map(e ->  ModeloResponseDTO.valueOf(e)).toList();
    }
}
