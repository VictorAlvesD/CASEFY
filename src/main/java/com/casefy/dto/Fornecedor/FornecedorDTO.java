package com.casefy.dto.Fornecedor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record FornecedorDTO(
    @NotBlank (message = "O campo nome do fornecedor não pode ser nulo.") String nome,
    @NotBlank (message = "O campo CNPJ do fornecedor não pode ser nulo.") @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "CNPJ inválido, use esse formato: XX.XXX.XXX/0001-XX") String cnpj,
    @NotBlank (message = "O campo email do fornecedor não pode ser nulo.") @Email(message = "O campo email não esta no formato correto!") String email
    ) {
}
