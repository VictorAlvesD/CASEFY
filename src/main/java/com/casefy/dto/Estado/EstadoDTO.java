package com.casefy.dto.Estado;

import jakarta.validation.constraints.NotBlank;

public record EstadoDTO(
        @NotBlank String nome,
        @NotBlank String sigla) {
}