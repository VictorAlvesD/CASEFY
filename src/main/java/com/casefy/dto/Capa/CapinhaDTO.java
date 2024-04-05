package com.casefy.dto.Capa;

import com.casefy.model.Capinha;
import com.casefy.model.Modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CapinhaDTO(
                @NotBlank(message = "O campo nome não pode ser nulo.") String nome,
                @NotBlank(message = "O campo descrição não pode ser nulo.") String descricao,
                @NotBlank(message = "O campo modelo não pode ser nulo.") Modelo modelo,
                @NotNull(message = "O campo valor não pode ser nulo.") Float valor) {
        public static CapinhaDTO valueOf(Capinha capinha) {
                return new CapinhaDTO(capinha.getNome(),
                                capinha.getDescricao(),
                                capinha.getModelo(),
                                capinha.getValor());
        }
}
