package com.casefy.resource;

import org.jboss.logging.Logger;

import com.casefy.application.Result;
import com.casefy.dto.Marca.MarcaDTO;
import com.casefy.dto.Marca.MarcaResponseDTO;
import com.casefy.service.Marca.MarcaService;

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

@Path("/marcas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaResource {

    @Inject
    MarcaService service;
    private static final Logger LOG = Logger.getLogger(ModeloResource.class);

    @POST
    //@RolesAllowed({   "Admin" })
    public Response insert(MarcaDTO dto) throws Exception {
        LOG.debug("Debug de inserção de Modelo.");
        try {
            LOG.info("Inserindo Marca");
            return Response.status(Status.CREATED).entity(service.insert(dto)).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao inserir uma Marca.");
            LOG.debug("Debug de inserção de Marca.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response update(MarcaDTO dto, @PathParam("id") Long id) {
        try {
            LOG.info("Atualizando Marca");
            service.update(dto, id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao atualizar uma Marca.");
            LOG.debug("Debug da atualização de Marca.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.info("Deletando a Marca");
            service.delete(id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao deletar uma Marca.");
            LOG.debug("Debug da exclusão do Marca.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    //@RolesAllowed({   "Admin" })
    public Response findAll() {
        LOG.info("Buscando todos as Marca.");
        LOG.debug("Debug de busca de lista de Marca.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response findById(@PathParam("id") Long id) {
        try {
            MarcaResponseDTO a = service.findById(id);
            LOG.info("Buscando uma Marca por ID.");
            LOG.debug("Debug de busca de ID de Marca.");
            return Response.ok(a).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar uma Marca por ID.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search/nome/{nome}")
    //@RolesAllowed({   "Admin" })
    public Response findByNome(@PathParam("nome") String nome) {
        try {
            LOG.info("Buscando Marca pelo nome.");
            LOG.debug("Debug de busca de Marca pelo nome.");
            return Response.ok(service.findByNome(nome)).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar Marca pelo nome.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
    
}
