package com.casefy.dto.Cidade;


import com.casefy.model.Cidade;
import com.casefy.model.Estado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CidadeDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    @NotNull(message = "O campo estado não pode ser nulo.")
    Estado estado
) {

    public static CidadeDTO valueOf(Cidade cidade) {
        return new CidadeDTO(cidade.getNome(), cidade.getEstado());
    }
}
