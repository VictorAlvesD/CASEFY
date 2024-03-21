package com.casefy.dto.Endereco;

import com.casefy.model.Cidade;
import com.casefy.model.Endereco;

public record EnderecoResponseDTO(
        Long id,
        String numero,
        String complemento,
        String cep,
        String nomeCidade,
        String estado) {

    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        Cidade cidade = endereco.getCidade();
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getCep(),
                cidade.getNome(),
                cidade.getEstado().getSigla()); }
}