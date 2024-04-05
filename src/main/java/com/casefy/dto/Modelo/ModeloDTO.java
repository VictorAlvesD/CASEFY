package com.casefy.dto.Modelo;

import com.casefy.model.Marca;
import com.casefy.model.Modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModeloDTO(
                @NotBlank(message = "O campo nome não pode ser nulo.")
                String nome,
                @NotNull(message = "O campo marca não pode ser nulo.")
                Marca marca
) {
    public static ModeloDTO valueOf(Modelo modelo) {
        return new ModeloDTO(modelo.getNome(), modelo.getMarca());
    }
}
