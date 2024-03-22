package com.casefy.dto.Cliente;

import java.util.List;

import com.casefy.dto.Endereco.EnderecoDTO;
import com.casefy.dto.Telefone.TelefoneDTO;
import com.casefy.model.Cliente;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String login,
        String cpf,
        List<TelefoneDTO> listaTelefones,
        List<EnderecoDTO> listaEnderecos) {
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        if (cliente == null) {
            return new ClienteResponseDTO(null, null, null, null, null, null);
        }
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getLogin(),
                cliente.getCpf(),
                cliente.getTelefone()
                        .stream()
                        .map(t -> TelefoneDTO.valueOf(t)).toList(),
                cliente.getEndereco()
                        .stream()
                        .map(t -> EnderecoDTO.valueOf(t)).toList()
        );
    }
}
