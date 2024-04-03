package com.casefy.repository;

import java.util.Date;
import java.util.List;

import com.casefy.model.Lote;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoteRepository implements PanacheRepository<Lote>{
    public List<Lote> findByDataCompra(Date data) {
        return find("dataCompra = ?1", data).list();
    }
}
