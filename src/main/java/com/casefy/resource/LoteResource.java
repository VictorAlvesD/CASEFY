package com.casefy.resource;

import java.sql.Date;

import org.jboss.logging.Logger;
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

import com.casefy.application.Result;
import com.casefy.service.Lote.LoteService;
import com.casefy.dto.Lote.*;

@Path("/lotes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoteResource {

    @Inject
    LoteService service;

    private static final Logger LOG = Logger.getLogger(ModeloResource.class);
    
    @POST
    @Transactional
    //@RolesAllowed({   "Admin" })
    public Response insert(LoteDTO dto) throws Exception {
        LOG.debug("Debug de inserção de Lote.");
        try {
            LOG.info("Inserindo Lote");
            return Response.status(Status.CREATED).entity(service.insert(dto)).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao inserir uma Lote.");
            LOG.debug("Debug de inserção de Lote.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response update(LoteDTO dto, @PathParam("id") Long id) {
        try {
            LOG.info("Atualizando Lote");
            service.update(dto, id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao atualizar uma Lote.");
            LOG.debug("Debug da atualização de Lote.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.info("Deletando a Lote");
            service.delete(id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao deletar uma Lote.");
            LOG.debug("Debug da exclusão do Lote.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    //@RolesAllowed({   "Admin" })
    public Response findAll() {
        LOG.info("Buscando todos as Lote.");
        LOG.debug("Debug de busca de lista de Lote.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response findById(@PathParam("id") Long id) {
        try {
            LoteResponseDTO a = service.findById(id);
            LOG.info("Buscando uma Lote por ID.");
            LOG.debug("Debug de busca de ID de Lote.");
            return Response.ok(a).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar uma Lote por ID.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search/codigo/{codigo}")
    //@RolesAllowed({   "Admin" })
    public Response findByCodigo(@PathParam("codigo") Long codgo) {
        try {
            LOG.info("Buscando Lote pelo codgo.");
            LOG.debug("Debug de busca de Lote pelo codgo.");
            return Response.ok(service.findByCodigo(codgo)).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar Lote pelo codgo.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
    
}
