package com.casefy.dto.ItemVenda;

import jakarta.validation.constraints.NotNull;

public record ItemVendaDTO (
    @NotNull(message = "O campo de quantidade não pode ser nulo.")
    Integer quantidade,
    @NotNull(message = "O campo de valor não pode ser nulo.")
    Double valor,
    Long idCapinha
) {
    
}
