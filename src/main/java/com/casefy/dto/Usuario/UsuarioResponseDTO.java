package com.casefy.dto.Usuario;

import com.casefy.model.Usuario;
import com.casefy.model.Perfil;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String login,
    Perfil perfil
) { 
    public static UsuarioResponseDTO valueOf(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getLogin(),
            usuario.getPerfil()
        );
    }
    
    
}