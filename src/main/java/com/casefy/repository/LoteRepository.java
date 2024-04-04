package com.casefy.repository;

import java.util.List;

import com.casefy.model.Lote;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoteRepository implements PanacheRepository<Lote>{
    public List<Lote> findByCodigo(String codigo) {
        return find("UPPER(codigo) LIKE UPPER(?1) ", "%" + codigo + "%").list();
    }
}
