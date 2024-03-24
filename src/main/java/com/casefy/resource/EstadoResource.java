package com.casefy.resource;

import org.jboss.logging.Logger;

import com.casefy.application.Result;
import com.casefy.dto.Estado.EstadoDTO;
import com.casefy.dto.Estado.EstadoResponseDTO;
import com.casefy.service.estado.EstadoService;

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

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    EstadoService service;

    private static final Logger LOG = Logger.getLogger(ModeloResource.class);

    @POST
    //@RolesAllowed({   "Admin" })
    public Response insert(EstadoDTO dto) throws Exception {
        LOG.debug("Debug de inserção de Estado.");
        try {
            LOG.info("Inserindo Estado");
            return Response.status(Status.CREATED).entity(service.insert(dto)).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao inserir uma Estado.");
            LOG.debug("Debug de inserção de Estado.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response update(EstadoDTO dto, @PathParam("id") Long id) {
        try {
            LOG.info("Atualizando Estado");
            service.update(dto, id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao atualizar uma Estado.");
            LOG.debug("Debug da atualização de Estado.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.info("Deletando a Estado");
            service.delete(id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao deletar uma Estado.");
            LOG.debug("Debug da exclusão do Estado.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    //@RolesAllowed({   "Admin" })
    public Response findAll() {
        LOG.info("Buscando todos as Estado.");
        LOG.debug("Debug de busca de lista de Estado.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response findById(@PathParam("id") Long id) {
        try {
            EstadoResponseDTO a = service.findById(id);
            LOG.info("Buscando uma Estado por ID.");
            LOG.debug("Debug de busca de ID de Estado.");
            return Response.ok(a).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar uma Estado por ID.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search/nome/{nome}")
    //@RolesAllowed({   "Admin" })
    public Response findByNome(@PathParam("nome") String nome) {
        try {
            LOG.info("Buscando Estado pelo nome.");
            LOG.debug("Debug de busca de Estado pelo nome.");
            return Response.ok(service.findByNome(nome)).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar Estado pelo nome.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
    
}
