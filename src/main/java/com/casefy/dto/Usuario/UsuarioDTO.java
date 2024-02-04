package com.casefy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UsuarioDTO(
        @NotBlank(message = "O campo nome não pode ser nulo.") String nome,
        @JsonProperty(required = true)
        @NotBlank(message = "O campo login não pode ser nulo.") String login,
        @NotBlank(message = "O campo senha não pode ser nulo.") String senha,
        @NotBlank(message = "O campo CPF não pode ser nulo.")@Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$", message = "CPF inválido! Utilize o modelo: 000.000.000-00") String cpf,
        @NotNull(message = "O campo perfil não pode ser nulo.") Integer idPerfil) 
{
}

