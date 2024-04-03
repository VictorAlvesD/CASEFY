package com.casefy.service.Fornecedor;

import java.util.List;

import com.casefy.dto.Fornecedor.FornecedorResponseDTO;
import com.casefy.dto.Fornecedor.FornecedorDTO;
import com.casefy.model.Fornecedor;
import com.casefy.repository.FornecedorRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService{

    @Inject
    FornecedorRepository fornecedorRepository;

    @Override
    public FornecedorResponseDTO insert(FornecedorDTO dto) {

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEmail(dto.email());

        fornecedorRepository.persist(fornecedor);

        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @Override
    public FornecedorResponseDTO update(FornecedorDTO dto, Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        if (fornecedor == null) {
            throw new EntityNotFoundException("Cidade com ID " + id + " não encontrada");
        }
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEmail(dto.email());

        fornecedorRepository.persist(fornecedor);

        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @Override
    public void delete(Long id) {
        if (!fornecedorRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public FornecedorResponseDTO findById(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        if (fornecedor == null) {
            throw new EntityNotFoundException("Fornecedor não encontrada com ID: " + id);
        }
        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @Override
    public List<FornecedorResponseDTO> findByNome(String nome) {
        return fornecedorRepository.findByNome(nome).stream().map( p -> FornecedorResponseDTO.valueOf(p)).toList();
    }

    @Override
    public List<FornecedorResponseDTO> findByAll() {
        return fornecedorRepository.findAll().stream().map(f -> FornecedorResponseDTO.valueOf(f)).toList();
    }
    
}
