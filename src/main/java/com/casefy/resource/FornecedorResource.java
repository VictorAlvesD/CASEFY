package com.casefy.resource;

import org.jboss.logging.Logger;

import com.casefy.application.Result;
import com.casefy.dto.Fornecedor.FornecedorDTO;
import com.casefy.dto.Fornecedor.FornecedorResponseDTO;
import com.casefy.service.Fornecedor.FornecedorService;

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

@Path("/fornecedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {

    @Inject
    FornecedorService service;

    private static final Logger LOG = Logger.getLogger(ModeloResource.class);

    @POST
    @Transactional
    //@RolesAllowed({   "Admin" })
    public Response insert(FornecedorDTO dto) throws Exception {
        LOG.debug("Debug de inserção de Fornecedor.");
        try {
            LOG.info("Inserindo Fornecedor");
            return Response.status(Status.CREATED).entity(service.insert(dto)).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao inserir uma Fornecedor.");
            LOG.debug("Debug de inserção de Fornecedor.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response update(FornecedorDTO dto, @PathParam("id") Long id) {
        try {
            LOG.info("Atualizando Fornecedor");
            service.update(dto, id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao atualizar uma Fornecedor.");
            LOG.debug("Debug da atualização de Fornecedor.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.info("Deletando a Fornecedor");
            service.delete(id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            LOG.error("Erro ao deletar uma Fornecedor.");
            LOG.debug("Debug da exclusão do Fornecedor.");
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    //@RolesAllowed({   "Admin" })
    public Response findAll() {
        LOG.info("Buscando todos as Fornecedor.");
        LOG.debug("Debug de busca de lista de Fornecedor.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({   "Admin" })
    public Response findById(@PathParam("id") Long id) {
        try {
            FornecedorResponseDTO a = service.findById(id);
            LOG.info("Buscando uma Fornecedor por ID.");
            LOG.debug("Debug de busca de ID de Fornecedor.");
            return Response.ok(a).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar uma Fornecedor por ID.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search/nome/{nome}")
    //@RolesAllowed({   "Admin" })
    public Response findByNome(@PathParam("nome") String nome) {
        try {
            LOG.info("Buscando Fornecedor pelo nome.");
            LOG.debug("Debug de busca de Fornecedor pelo nome.");
            return Response.ok(service.findByNome(nome)).build();
        } catch (EntityNotFoundException e) {
            LOG.error("Erro ao buscar Fornecedor pelo nome.");
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
    
}
