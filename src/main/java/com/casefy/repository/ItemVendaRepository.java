package com.casefy.repository;

import java.util.List;

import com.casefy.model.Cliente;
import com.casefy.model.ItemVenda;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemVendaRepository implements PanacheRepository<ItemVenda> {
    public List<ItemVenda> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }

    public List<ItemVenda> findItensByUsuario(Cliente cliente) {
        return find("select i from Pedido p join p.itens i where p.cliente = ?1", cliente).list();
    }

}
