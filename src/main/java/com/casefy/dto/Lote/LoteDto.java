package com.casefy.dto.Lote;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoteDTO(
    @NotNull (message = "O campo do fornecedor não pode ser nulo") Long idfornecedor,
    @NotNull(message = "O campo do codigo não pode ser nulo") Long codigo,
    @NotNull (message = "O campo quantidade de itens não pode ser nulo") Integer quantidadeItens,
    @NotNull (message = "O campo valor unitario não pode ser nulo") Float valorUnitario,
    @NotNull (message = "O campo valor total não pode ser nulo") Float valorTotal,
    @JsonFormat(pattern = "dd/MM/yyyy") @NotBlank (message = "A data não pode ser nula") Date dataCompra
    ) {

}