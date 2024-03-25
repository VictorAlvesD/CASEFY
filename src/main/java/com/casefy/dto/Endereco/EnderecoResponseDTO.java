package com.casefy.dto.Endereco;

import com.casefy.dto.Cidade.CidadeResponseDTO;
import com.casefy.model.Endereco;

public record EnderecoResponseDTO(
        Long id,
        String numero,
        String complemento,
        String cep,
        CidadeResponseDTO cidade) {

    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getCep(),
                CidadeResponseDTO.valueOf(endereco.getCidade())
                ); }
}