package com.casefy.dto.Endereco;

import com.casefy.model.Cidade;
import com.casefy.model.Endereco;

public record EnderecoResponseDTO(
        Long id,
        String numero,
        String complemento,
        String cep,
        Cidade cidade) {
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getCep(),
                endereco.getCidade());
    }
}