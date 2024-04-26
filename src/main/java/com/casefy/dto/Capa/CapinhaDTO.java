package com.casefy.dto.Capa;

import com.casefy.model.Capinha;
import com.casefy.model.Modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CapinhaDTO(
                @NotBlank(message = "O campo nome não pode ser nulo.") String nome,
                @NotBlank(message = "O campo descrição não pode ser nulo.") String descricao,
                @NotBlank(message = "O campo modelo não pode ser nulo.") Long modelo,
                @NotNull(message = "O campo valor não pode ser nulo.") Float valor) {
        public static Capinha valueOf(CapinhaDTO capinhaDTO) {
                Capinha capinha = new Capinha();
                capinha.setNome(capinhaDTO.nome);
                capinha.setDescricao(capinhaDTO.descricao);
                capinha.setValor(capinhaDTO.valor);
                return capinha;
        }
}
