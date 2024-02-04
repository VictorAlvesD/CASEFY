package com.casefy.resource;


import org.jboss.logging.Logger;
import com.casefy.application.Result;
import com.casefy.dto.ClienteDTO;
import com.casefy.dto.ClienteResponseDTO;
import com.casefy.service.ClienteService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService service;

    private static final Logger LOG = Logger.getLogger(ClienteResource.class);

    @POST
    @RolesAllowed({   "Admin" })
    public Response insert(ClienteDTO dto) throws Exception {
        LOG.debug("Debug de inserção de clientes.");
        try {
            LOG.info("Inserindo cliente");
            return Response.status(Status.CREATED).entity(service.insert(dto)).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug de inserção de clientes.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({   "Admin" })
    public Response update(ClienteDTO dto, @PathParam("id") Long id) {
        try {
            LOG.info("Atualizando cliente");
            service.update(dto, id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug da atualização de clientes.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({   "Admin" })
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.info("Deletando o cliente");
            service.delete(id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.debug("Debug da exclusão do cliente.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    @RolesAllowed({   "Admin" })
    public Response findAll() {
        LOG.info("Buscando todos os clientes.");
        LOG.debug("Debug de busca de lista de clientes.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({   "Admin" })
    public Response findById(@PathParam("id") Long id) {
        try {
            ClienteResponseDTO a = service.findById(id);
            LOG.info("Buscando um cliente por ID.");
            LOG.debug("Debug de busca de ID de clientes.");
            return Response.ok(a).build();
        } catch (EntityNotFoundException e) {
            LOG.info("Erro ao buscar um cliente por ID.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({   "Admin" })
    public Response findByNome(@PathParam("nome") String nome) {
        try {
            LOG.info("Buscando um cliente por ID.");
            LOG.debug("Debug de busca de ID de clientes.");
            return Response.ok(service.findByNome(nome)).build();
        } catch (EntityNotFoundException e) {
            LOG.info("Erro ao buscar um cliente por ID.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
