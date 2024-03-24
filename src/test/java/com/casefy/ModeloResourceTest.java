package com.casefy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.casefy.dto.Login.LoginDTO;
import com.casefy.dto.Modelo.*;
import com.casefy.service.Modelo.ModeloService;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jakarta.inject.Inject;

@QuarkusTest
public class ModeloResourceTest {
    @Inject
    ModeloService modeloService;
 private String token;

    @BeforeEach
    public void setUp() {
        var auth = new LoginDTO("victor@unitins.br", "123");

        Response response = (Response) given()
                .contentType("application/json")
                .body(auth)
                .when().post("/auth")
                .then()
                .statusCode(200)
                .extract().response();

        token = response.header("Authorization");
    }
    @Test
    public void testFindAll() {
        given()
        .header("Authorization", "Bearer " + token)
            .when().get("/modelos")
            .then()
            .statusCode(200);
    }

    @Test
    public void testInsert() {
        ModeloDTO dtoModelo = new ModeloDTO(
            "Nome teste",
            "Marca teste"
        );

        given()
        .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(dtoModelo)
                .when().post("/modelos")
                .then()
                .statusCode(201)
                .body(
                        "id", notNullValue(),
                        "nome", is("Nome teste"),
                        "marca", is("Marca teste"));
    }

    @Test
    public void testUpdate() {
        ModeloDTO dtoModelo = new ModeloDTO(
            "Nome Teste",
            "Marca Teste"
        );

        ModeloResponseDTO modeloTest = modeloService.insert(dtoModelo);
        Long id = modeloTest.id();
        
        ModeloDTO dtoModeloUpdate = new ModeloDTO(
            "Nome Teste2",
            "Marca Teste2"
        );

        given()
        .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(dtoModeloUpdate)
                .when().put("/modelos/" + id)
                .then()
                .statusCode(204);

        ModeloResponseDTO modelo = modeloService.findById(id);
        assertThat(modelo.nome(), is("Nome Teste2"));
        assertThat(modelo.marca(), is("Marca Teste2"));

    }

    @Test
    public void testRemoveModelo() {
        ModeloDTO dtoModelo = new ModeloDTO(
            "Nome Teste",
            "Marca Teste"
        );

        ModeloResponseDTO modeloInserido = modeloService.insert(dtoModelo);
        Long idModelo = modeloInserido.id();

        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .delete("/modelos/" + idModelo)
            .then()
            .statusCode(204);

        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .get("/modelos/" + idModelo)
            .then()
            .statusCode(404);
    }

    @Test
    public void testFindById() {
        ModeloDTO dtoModelo = new ModeloDTO(
            "Nome Teste",
            "Marca Teste"
        );

        ModeloResponseDTO modeloTest = modeloService.insert(dtoModelo);
        Long id = modeloTest.id();

        given()
        .header("Authorization", "Bearer " + token)
            .when().get("/modelos/{id}", id)
            .then()
            .statusCode(200)
            .body("id", equalTo(id.intValue()));
    }

    @Test
    public void testFindByIdNotFound() {
        Long NotExistingId = 9999L;

        given()
        .header("Authorization", "Bearer " + token)
            .when().get("/modelos/{id}", NotExistingId)
            .then()
            .statusCode(404);
    }

    /*@Test
    public void testFindByNome() {
        String existingName = "Nome teste";

        given()
            .when().get("/modelos/search/nome/{nome}", existingName)
            .then()
            .statusCode(200)
            .body("nome[0]", equalTo(existingName));
    }*/

}
