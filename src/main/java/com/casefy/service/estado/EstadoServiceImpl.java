package com.casefy.service.estado;

import java.util.List;

import com.casefy.dto.Estado.EstadoDTO;
import com.casefy.dto.Estado.EstadoResponseDTO;
import com.casefy.model.Estado;
import com.casefy.repository.EstadoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;
@ApplicationScoped
public class EstadoServiceImpl implements EstadoService{

    @Inject
    EstadoRepository estadoRepository;

    @Override
    public EstadoResponseDTO insert(EstadoDTO dto) {

        Estado estado = new Estado();
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());

        estadoRepository.persist(estado);

        return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    public EstadoResponseDTO update(EstadoDTO dto, Long id) {
        Estado estado = estadoRepository.findById(id);

        if (estado == null) {
            throw new EntityNotFoundException("Estado com ID " + id + " não encontrada");
        }
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());
        
        estadoRepository.persist(estado);

        return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    public void delete(Long id) {
        if (!estadoRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        Estado estado = estadoRepository.findById(id);
        if (estado == null) {
            throw new EntityNotFoundException("Estado não encontrada com ID: " + id);
        }
        return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
       return estadoRepository.findByNome(nome).stream()
        .map(e -> EstadoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<EstadoResponseDTO> findByAll() {
        return estadoRepository.listAll().stream().map(e -> EstadoResponseDTO.valueOf(e)).toList();
    }
    
}
