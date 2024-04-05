package com.casefy.resource;
import org.jboss.logging.Logger;

import com.casefy.service.Promocao.PromocaoService;
import com.casefy.application.Result;
import com.casefy.dto.Promocao.*;

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

@Path("/promocao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PromocaoResource {
    @Inject
    PromocaoService service;

    private static final Logger LOG = Logger.getLogger(ModeloResource.class);

    @POST
    @Transactional
    //@RolesAllowed({   "Admin" })
    public Response insert(PromocaoDTO dto) throws Exception {
        LOG.debug("Debug de inserção de Promocao.");
        try {
            LOG.info("Inserindo Promocao");
            return Response.status(Status.CREATED).entity(service.insert(dto)).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao inserir uma Promocao.");
            LOG.debug("Debug de inserção de Promocao.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response update(PromocaoDTO dto, @PathParam("id") Long id) {
        try {
            LOG.info("Atualizando Promocao");
            service.update(dto, id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao atualizar uma Promocao.");
            LOG.debug("Debug da atualização de Promocao.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.info("Deletando a Promocao");
            service.delete(id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao deletar uma Promocao.");
            LOG.debug("Debug da exclusão do Promocao.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    //@RolesAllowed({   "Admin" })
    public Response findAll() {
        LOG.info("Buscando todos as Promocao.");
        LOG.debug("Debug de busca de lista de Promocao.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response findById(@PathParam("id") Long id) {
        try {
            PromocaoResponseDTO a = service.findById(id);
            LOG.info("Buscando uma Promocao por ID.");
            LOG.debug("Debug de busca de ID de Promocao.");
            return Response.ok(a).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar uma Promocao por ID.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search/{codigo}")
    //@RolesAllowed({   "Admin" })
    public Response findByCodigo(@PathParam("codigo") String codigo) {
        try {
            LOG.info("Buscando Promocao pelo codigo.");
            LOG.debug("Debug de busca de Promocao pelo codigo.");
            return Response.ok(service.findByCodigo(codigo)).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar Promocao pelo codigo.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
