package com.casefy.service.Lote;

import java.util.Date;
import java.util.List;

import com.casefy.dto.Lote.LoteDto;
import com.casefy.dto.Lote.LoteResponseDto;
import com.casefy.model.Fornecedor;
import com.casefy.model.Lote;
import com.casefy.repository.FornecedorRepository;
import com.casefy.repository.LoteRepository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoteServiceImpl implements LoteService {
    @Inject
    LoteRepository loteRepository;

    @Inject
    FornecedorRepository fornecedorRepository;

    @Override
    public LoteResponseDto insert(LoteDto dto) {
        // Verifica se o fornecedor já existe no banco de dados
        Fornecedor fornecedorExistente = fornecedorRepository.findByCnpj(dto.fornecedor().cnpj());

        if (fornecedorExistente != null) {
            // Se o fornecedor já existir, atribui o fornecedor existente ao lote
            var lote = new Lote();
            lote.setQuantidadeItens(dto.quantidadeItens());
            lote.setValorUnitario(dto.valorUnitario());
            lote.setValorTotal(dto.valorTotal());
            lote.setDataCompra(dto.dataCompra());

            lote.setFornecedor(fornecedorExistente);

            loteRepository.persist(lote);

            return LoteResponseDto.valueOf(lote);
        } else {
            throw new EntityNotFoundException(
                    "Fornecedor não encontrado com o CNPJ fornecido: " + dto.fornecedor().cnpj());
        }
    }

    @Override
    public LoteResponseDto update(LoteDto dto, Long id) {
        Lote loteExistente = loteRepository.findById(id);
        if (loteExistente != null) {
            loteExistente.setQuantidadeItens(dto.quantidadeItens());
            loteExistente.setValorUnitario(dto.valorUnitario());
            loteExistente.setValorTotal(dto.valorTotal());
            loteExistente.setDataCompra(dto.dataCompra());

            Fornecedor fornecedorExistente = fornecedorRepository.findByCnpj(dto.fornecedor().cnpj());
            loteExistente.setFornecedor(fornecedorExistente);
            loteRepository.persist(loteExistente);

            return LoteResponseDto.valueOf(loteExistente);
        }else{
            throw new EntityNotFoundException(
                    "Lote não cadastrado!");
        }
    }

    @Override
    public void delete(Long id) {
        if (!loteRepository.deleteById(id))
            throw new NotFoundException("A exclusão falhou falhou!");
    }

    @Override
    public LoteResponseDto findById(Long id) {
        Lote lote = loteRepository.findById(id);
        if (lote != null) {
            return LoteResponseDto.valueOf(lote);
        }else{
            throw new EntityNotFoundException("Lote não encontrado com o ID: " + id);
        }
    }

    @Override
    public List<LoteResponseDto> findByData(Date data) {
        List<Lote> lotes = loteRepository.findByDataCompra(data);
        if (lotes == null) {
            throw new EntityNotFoundException("Lote não encontrado com a data" + data);
        }
        return lotes.stream().map(e -> LoteResponseDto.valueOf(e)).toList();
    }

    @Override
    public List<LoteResponseDto> findByAll() {
        return loteRepository.findAll().stream().map(f -> LoteResponseDto.valueOf(f)).toList();
    }

}
