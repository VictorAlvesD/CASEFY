
package com.casefy;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakarta.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.casefy.dto.ItemVenda.ItemVendaDTO;
import com.casefy.dto.Login.LoginDTO;
import com.casefy.dto.Pedido.*;

import com.casefy.service.Capa.CapinhaService;
import com.casefy.service.Cidade.CidadeService;
import com.casefy.service.Cliente.ClienteService;
import com.casefy.service.Endereco.EnderecoService;
import com.casefy.service.Estado.EstadoService;
import com.casefy.service.Pedido.PedidoService;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class PedidoResourceTest {
        @Inject
        ClienteService clienteService;

        @Inject
        EstadoService estadoService;

        @Inject
        CidadeService cidadeService;

        @Inject
        EnderecoService enderecoService;

        @Inject
        PedidoService pedidoService;

        @Inject
        CapinhaService capinhaService;

        private String token;
        private String tokenAdm;

        @BeforeEach
        public void setUp() {
                var auth = new LoginDTO("alves@unitins.br", "123");

                Response response = (Response) given()
                                .contentType("application/json")
                                .body(auth)
                                .when().post("/auth")
                                .then()
                                .statusCode(200)
                                .extract().response();

                token = response.header("Authorization");
        }
        @BeforeEach
        public void setUp2() {
                var auth = new LoginDTO("victor@unitins.br", "123");

                Response response = (Response) given()
                                .contentType("application/json")
                                .body(auth)
                                .when().post("/auth")
                                .then()
                                .statusCode(200)
                                .extract().response();

                tokenAdm = response.header("Authorization");
        }

        @Test
        public void testFindAll() {
                given()
                                .header("Authorization", "Bearer " + token)
                                .when().get("/pedidos")
                                .then()
                                .statusCode(200);
        }

        @Test
        public void testInsert() throws ParseException {

                List<ItemVendaDTO> listaItens = new ArrayList<ItemVendaDTO>();
                listaItens.add(new ItemVendaDTO(2, 22.5, 1L));

                PedidoDTO dtoPedido = new PedidoDTO(1L, listaItens);
                given()
                                .header("Authorization", "Bearer " + token)
                                .contentType(ContentType.JSON)
                                .body(dtoPedido)
                                .when().post("/pedidos")
                                .then()
                                .statusCode(201)
                                .body(
                                                "id", notNullValue());
        }

        @Test
        public void testRemovePedido() throws Exception {

                List<ItemVendaDTO> listaItens = new ArrayList<ItemVendaDTO>();
                listaItens.add(new ItemVendaDTO(2, 22.5, 1L));

                PedidoDTO dtoPedido = new PedidoDTO(1L, listaItens);

                PedidoResponseDTO pedidoInserido = pedidoService.insert(dtoPedido, token);
                Long idRemove = pedidoInserido.id();

                given()
                                .header("Authorization", "Bearer " + token)
                                .when()
                                .delete("/pedidos/" + idRemove)
                                .then()
                                .statusCode(204);
        }

        @Test
        public void testFindById() throws Exception {
                List<ItemVendaDTO> listaItens = new ArrayList<ItemVendaDTO>();
                listaItens.add(new ItemVendaDTO(2, 22.5, 1L));

                PedidoDTO dtoPedido = new PedidoDTO(1L, listaItens);

                PedidoResponseDTO pedidoInserido = pedidoService.insert(dtoPedido, token);
                Long idPesquisa = pedidoInserido.id();
                System.out.println(idPesquisa);

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when().get("/pedidos/{id}", idPesquisa)
                                .then()
                                .statusCode(200)
                                .body("id", equalTo(idPesquisa.intValue()));
        }

}
