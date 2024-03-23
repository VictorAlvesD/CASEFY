package com.casefy.dto.Marca;

import com.casefy.model.Marca;

import jakarta.validation.constraints.NotBlank;

public record MarcaDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome
) {
    public static MarcaDTO valueOf(Marca marca) {
        return new MarcaDTO(marca.getNome());
    }
    
}