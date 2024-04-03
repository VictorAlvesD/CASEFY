package com.casefy.service.Lote;

import java.util.List;

import com.casefy.dto.Lote.*;
import com.casefy.model.Fornecedor;
import com.casefy.model.Lote;
import com.casefy.repository.FornecedorRepository;
import com.casefy.repository.LoteRepository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoteServiceImpl implements LoteService {
    @Inject
    LoteRepository loteRepository;

    @Inject
    FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public LoteResponseDTO insert(LoteDTO dto) {

        // Criação do novo lote
        var lote = new Lote();
        lote.setQuantidadeItens(dto.quantidadeItens());
        lote.setValorUnitario(dto.valorUnitario());
        lote.setValorTotal(dto.valorTotal());
        lote.setEstoque(dto.estoque());
        lote.setDataCompra(dto.dataCompra());
        lote.setCodigo(dto.codigo());

        // Busca do fornecedor pelo ID
        Fornecedor fornecedor = fornecedorRepository.findById(dto.idfornecedor());
        if (fornecedor == null) {
            throw new EntityNotFoundException("Fornecedor não cadastrado! ID: " + dto.idfornecedor());
        }
        lote.setFornecedor(fornecedor);
        // Adiciona o lote à lista de lotes do fornecedor
        fornecedor.getLotes().add(lote);

        // Persiste o lote e o fornecedor
        loteRepository.persist(lote);
        fornecedorRepository.persist(fornecedor);

        return LoteResponseDTO.valueOf(lote);

    }

    @Override
    @Transactional
    public LoteResponseDTO update(LoteDTO dto, Long id) {
        Lote loteExistente = loteRepository.findById(id);
        if (loteExistente != null) {
            loteExistente.setQuantidadeItens(dto.quantidadeItens());
            loteExistente.setValorUnitario(dto.valorUnitario());
            loteExistente.setValorTotal(dto.valorTotal());
            loteExistente.setEstoque(dto.estoque());
            loteExistente.setDataCompra(dto.dataCompra());
            loteExistente.setCodigo(dto.codigo());
            
            // Busca do fornecedor pelo ID
            Fornecedor fornecedor = fornecedorRepository.findById(dto.idfornecedor());
            if (fornecedor == null) {
                throw new EntityNotFoundException("Fornecedor não cadastrado! ID: " + dto.idfornecedor());
            }
            loteExistente.setFornecedor(fornecedor);
            // Adiciona o lote à lista de lotes do fornecedor
            fornecedor.getLotes().add(loteExistente);

            // Persiste o lote e o fornecedor
            loteRepository.persist(loteExistente);
            fornecedorRepository.persist(fornecedor);

            return LoteResponseDTO.valueOf(loteExistente);
        } else {
            throw new EntityNotFoundException(
                    "Lote não cadastrado!");
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!loteRepository.deleteById(id))
            throw new NotFoundException("A exclusão falhou falhou!");
    }

    @Override
    public LoteResponseDTO findById(Long id) {
        Lote lote = loteRepository.findById(id);
        if (lote != null) {
            return LoteResponseDTO.valueOf(lote);
        } else {
            throw new EntityNotFoundException("Lote não encontrado com o ID: " + id);
        }
    }

    @Override
    public List<LoteResponseDTO> findByCodigo(Long cod) {
        List<Lote> lotes = loteRepository.findByCodigo(cod);
        if (lotes == null) {
            throw new EntityNotFoundException("Lote não encontrado com a codigo: " + cod);
        }
        return lotes.stream().map(e -> LoteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<LoteResponseDTO> findByAll() {
        return loteRepository.findAll().stream().map(f -> LoteResponseDTO.valueOf(f)).toList();
    }

}
