package com.casefy.dto.Capa;

import com.casefy.model.Cor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CapinhaDTO(
        @NotBlank(message = "O campo nome não pode ser nulo.") String nome,
        @NotBlank(message = "O campo modelo não pode ser nulo.") Long idModelo,
        Cor cor,
        @NotNull(message = "O campo valor não pode ser nulo.") Float valor,
        @NotNull(message = "O campo quantidade em estoque não pode ser nulo.") Integer quantEstoque,
        @NotBlank(message = "O campo descrição não pode ser nulo.") String descricao) {

}