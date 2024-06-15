package com.casefy.service.Administrador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.casefy.dto.Administrador.AdministradorDTO;
import com.casefy.dto.Administrador.AdministradorResponseDTO;
import com.casefy.model.Administrador;
import com.casefy.model.NivelAcesso;
import com.casefy.model.Perfil;
import com.casefy.model.Usuario;
import com.casefy.repository.AdministradorRepository;
import com.casefy.repository.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class AdministradorServiceImpl implements AdministradorService {

    @Inject
    AdministradorRepository repository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public AdministradorResponseDTO insert(AdministradorDTO dto) {
        Administrador novoAdministrador = new Administrador();
        novoAdministrador.setNome(dto.nome());
        novoAdministrador.setCpf(dto.cpf());
        novoAdministrador.setLogin(dto.email());
        novoAdministrador.setSenha(dto.senha());
        novoAdministrador.setMatricula(dto.matricula());
        novoAdministrador.setPerfil(Perfil.ADMIN);
        novoAdministrador.setNivelAcesso(NivelAcesso.valueOf(dto.idNivelAcesso()));

        repository.persist(novoAdministrador);

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.email());
        usuario.setSenha(dto.senha());

        usuarioRepository.persist(usuario);


        return AdministradorResponseDTO.valueOf(novoAdministrador);
    }

    @Override
    @Transactional
    public AdministradorResponseDTO update(AdministradorDTO dto, Long id) {

        Administrador admExistente = repository.findById(id);

        admExistente.setNome(dto.nome());
        admExistente.setCpf(dto.cpf());
        admExistente.setLogin(dto.email());
        admExistente.setSenha(dto.senha());
        admExistente.setMatricula(dto.matricula());
        admExistente.setPerfil(Perfil.ADMIN);
        admExistente.setNivelAcesso(NivelAcesso.valueOf(dto.idNivelAcesso()));

        repository.persist(admExistente);
        
        return AdministradorResponseDTO.valueOf(admExistente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public AdministradorResponseDTO findById(Long id) {
        Administrador administrador = repository.findById(id);
        if (administrador == null) {
            throw new EntityNotFoundException("Administrador não encontrado com ID: " + id);
        }
        return AdministradorResponseDTO.valueOf(administrador);
    }

    @Override
    public List<AdministradorResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> AdministradorResponseDTO.valueOf(e)).toList();
    }

    @Override
    public AdministradorResponseDTO findByMatricula(Integer matricula) {
        Administrador administrador = repository.findByMatricula(matricula);
        if (administrador != null) {
            return AdministradorResponseDTO.valueOf(administrador);
        } else {
            return null;
        }
    }

    @Override
    public List<AdministradorResponseDTO> findByAll(int pag, int pageSize, String nome) {
        List<Administrador> list = new ArrayList();
        list = repository.findAll().page(pag, pageSize).list();
        if(nome != null){
            list = list.stream().filter(a -> a.getNome().contains(nome)).collect(Collectors.toList());
        }
        return list.stream().map(e -> AdministradorResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count(){
        return repository.count();
    }
}
