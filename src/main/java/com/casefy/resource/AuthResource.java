package com.casefy.resource;


import org.jboss.logging.Logger;

import com.casefy.dto.Login.*;
import com.casefy.dto.Usuario.*;
import com.casefy.service.Hash.HashService;
import com.casefy.service.JWT.*;
import com.casefy.service.Usuario.*;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    UsuarioService service;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    private static final Logger LOG = Logger.getLogger(AuthResource.class);

    @POST
    public Response login(@Valid LoginDTO dto) {
       
        LOG.infof("Iniciando a autenticacao do %s", dto.login());
        
        String hashSenha = hashService.getHashSenha(dto.senha());
        LOG.info("Hash da senha gerado ");

        UsuarioResponseDTO result = service.findByLoginAndSenha(dto.login(), hashSenha);
        
        if (result != null) {
            LOG.info("Login e senha corretos.");
            String token = jwtService.generateJwt(result);
            LOG.info("Token JWT gerado com sucesso.");

            // Retornar o token JWT na resposta
            return Response.ok(result)
                    .header("Authorization", "Bearer " + token)
                    .build();
        } else {
            LOG.info("Login e senha incorretos.");
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}
