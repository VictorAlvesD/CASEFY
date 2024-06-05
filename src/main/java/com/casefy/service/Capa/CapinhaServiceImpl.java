package com.casefy.service.Capa;

import java.util.List;
import java.util.stream.Collectors;

import com.casefy.dto.Capa.*;
import com.casefy.model.Capinha;
import com.casefy.model.Modelo;
import com.casefy.repository.CapinhaRepository;
import com.casefy.repository.ModeloRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CapinhaServiceImpl implements CapinhaService {
    @Inject
    CapinhaRepository capinhaRepository;

    @Inject
    ModeloRepository modeloRepository;


    @Override
    @Transactional
    public CapinhaResponseDTO insert(CapinhaDTO dto) {

        Capinha novaCapinha = new Capinha();
        novaCapinha = CapinhaDTO.valueOf(dto);

        Modelo modelo = modeloRepository.findById(dto.modelo());
        novaCapinha.setModelo(modelo);

        capinhaRepository.persist(novaCapinha);

        return CapinhaResponseDTO.valueOf(novaCapinha);
    }

    @Override
    @Transactional
    public CapinhaResponseDTO update(CapinhaDTO dto, Long id) {

        Capinha capinhaExistente = capinhaRepository.findById(id);
        if (capinhaExistente == null) {
            throw new EntityNotFoundException("Capinha com ID " + id + " não encontrada");
        }

        capinhaExistente.setNome(dto.nome());
        capinhaExistente.setDescricao(dto.descricao());

        Modelo modelo = modeloRepository.findById(dto.modelo());
        capinhaExistente.setModelo(modelo);

        capinhaExistente.setValor(dto.valor());

        capinhaRepository.persist(capinhaExistente);
        return CapinhaResponseDTO.valueOf(capinhaExistente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!capinhaRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public CapinhaResponseDTO findById(Long id) {
        Capinha capinha = capinhaRepository.findById(id);
        if (capinha == null) {
            throw new EntityNotFoundException("Capinha não encontrada com ID: " + id);
        }
        return CapinhaResponseDTO.valueOf(capinha);
    }

    @Override
    public List<CapinhaResponseDTO> findByNome(String nome) {
        return capinhaRepository.findByNome(nome).stream()
                .map(e -> CapinhaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CapinhaResponseDTO> findByAll() {
        return capinhaRepository.listAll().stream()
                .map(e -> CapinhaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public CapinhaResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Capinha capinha = capinhaRepository.findById(id);
        capinha.setNomeImagem(nomeImagem);
        return CapinhaResponseDTO.valueOf(capinha);}

    @Override
    public List<CapinhaResponseDTO> getAllPaginacao(int page, int pageSize) {
        List<Capinha> list = capinhaRepository
                                .findAll()
                                .page(page, pageSize)
                                .list();
        
        return list.stream().map(e -> CapinhaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }
}
