package com.casefy.dto.Marca;

import jakarta.validation.constraints.NotBlank;

public record MarcaDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome
) {
    
}