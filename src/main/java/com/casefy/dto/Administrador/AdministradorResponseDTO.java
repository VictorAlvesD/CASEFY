package com.casefy.dto.Administrador;

import com.casefy.model.Administrador;
import com.casefy.model.NivelAcesso;

public record AdministradorResponseDTO(
        Long id,
        String nome,
        Integer matricula,
        String email,
        String cpf,
        String perfil,
        String senha,
        NivelAcesso idNivelAcesso) {
    public static AdministradorResponseDTO valueOf(Administrador adm) {
        return new AdministradorResponseDTO(
                adm.getId(),
                adm.getNome(),
                adm.getMatricula(),
                adm.getEmail(),
                adm.getCpf(),
                adm.getPerfil().getLabel(),
                adm.getSenha(),
                adm.getNivelAcesso()
                );
    }
}
