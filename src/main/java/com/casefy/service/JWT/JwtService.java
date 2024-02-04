package com.casefy.service.JWT;

import com.casefy.dto.Usuario.*;

public interface JwtService {

    public String generateJwt(UsuarioResponseDTO dto);
    
}
