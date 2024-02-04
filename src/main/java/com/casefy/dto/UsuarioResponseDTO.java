package com.casefy.dto;

import com.casefy.model.Usuario;
import com.casefy.model.Perfil;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String cpf,
    String login,
    Perfil perfil
) { 
    public static UsuarioResponseDTO valueOf(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getCpf(),
            usuario.getLogin(),
            usuario.getPerfil()
        );
    }
    
    
}