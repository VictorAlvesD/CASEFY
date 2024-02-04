
package com.casefy;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import com.casefy.dto.Usuario.*;
import com.casefy.dto.Login.LoginDTO;
import com.casefy.service.Usuario.UsuarioService;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class UsuarioResourceTest {
    @Inject
    UsuarioService UsuarioService;

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
                .when().get("/usuarios")
                .then()
                .statusCode(200);
    }

    @Test
    public void testInsert() {
        UsuarioDTO dtoUsuario = new UsuarioDTO(
                "Milly Melo",
                "milly@gmail.com",
                "15987",
                "159.684.456-02",
                1);

        given()
        .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(dtoUsuario)
                .when().post("/usuarios")
                .then()
                .statusCode(201)
                .body(
                        "id", notNullValue(),
                        "nome", is("Milly Melo"));
    }

    @Test
    public void testUpdate() {
        UsuarioDTO dto = new UsuarioDTO(
                "Milly Melo",
                "milly@gmail.com",
                "15987",
                "159.684.456-02",
                1);

        // inserindo um usuario
        UsuarioResponseDTO usuarioTest = UsuarioService.insert(dto);
        Long id = usuarioTest.id();

        UsuarioDTO dtoUpdate = new UsuarioDTO(
                "Pierre",
                "mily@gmail.com",
                "15987",
                "159.684.456-02",
                1);

        given()
        .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(dtoUpdate)
                .when().put("/usuarios/" + id)
                .then()
                .statusCode(204);

    }

    @Test
    public void testRemoveUsuario() {
        UsuarioDTO dto = new UsuarioDTO(
                "Milly Melo",
                "milly@gmail.com",
                "15987",
                "159.684.456-02",
                1);

        UsuarioResponseDTO UsuarioInserido = UsuarioService.insert(dto);
        Long idUsuario = UsuarioInserido.id();

        given()
        .header("Authorization", "Bearer " + token)
                .when()
                .delete("/usuarios/" + idUsuario)
                .then()
                .statusCode(204); 

    }

    @Test
    public void testFindById() {
        UsuarioDTO dto = new UsuarioDTO(
                "Milly Melo",
                "milly@gmail.com",
                "15987",
                "159.684.456-02",
                1);
        UsuarioResponseDTO usuarioTest = UsuarioService.insert(dto);
        Long id = usuarioTest.id();

        given()
        .header("Authorization", "Bearer " + token)
                .when().get("/usuarios/{id}", id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id.intValue()));
    }

}
