package com.casefy.dto.Promocao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PromocaoDTO(
    @NotBlank String codigo,
    @NotBlank String descricao,
    @NotNull Float valorDesconto
) {
} 
