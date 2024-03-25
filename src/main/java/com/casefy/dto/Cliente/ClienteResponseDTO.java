package com.casefy.dto.Cliente;

import java.util.List;

import com.casefy.dto.Endereco.EnderecoResponseDTO;
import com.casefy.dto.Telefone.TelefoneResponseDTO;
import com.casefy.model.Cliente;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String login,
        String cpf,
        List<TelefoneResponseDTO> listaTelefones,
        List<EnderecoResponseDTO> listaEnderecos) {
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
                        .map(t -> TelefoneResponseDTO.valueOf(t)).toList(),
                cliente.getEndereco()
                        .stream()
                        .map(t -> EnderecoResponseDTO.valueOf(t)).toList()
        );
    }
}
