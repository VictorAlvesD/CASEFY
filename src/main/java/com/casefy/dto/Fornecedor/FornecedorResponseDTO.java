package com.casefy.dto.Fornecedor;

import com.casefy.model.Fornecedor;

public record FornecedorResponseDTO(
        Long id,
        String nome,
        String cnpj,
        String email) {

    public static  FornecedorResponseDTO valueOf(Fornecedor fornecedor){
        if (fornecedor == null) {
            return null; // Retorna null se o fornecedor for nulo
        }
        return new FornecedorResponseDTO(
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getCnpj(),
            fornecedor.getEmail()
            );
    }
}