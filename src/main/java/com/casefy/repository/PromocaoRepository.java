package com.casefy.repository;

import java.util.List;

import com.casefy.model.Promocao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PromocaoRepository implements PanacheRepository<Promocao>{
    public List<Promocao> findByCodigo(String codigo) {
        return find("codigo = ?1", codigo).list();
    }
}
