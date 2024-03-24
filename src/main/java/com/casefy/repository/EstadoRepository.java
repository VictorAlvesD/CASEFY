package com.casefy.repository;

import java.util.List;

import com.casefy.model.Estado;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado>{
    public List<Estado> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome+"%").list();
    }
    public List<Estado> findByNomeAndSigla(String nome, String sigla) {
        return find("UPPER(nome) LIKE UPPER(?1) AND UPPER(sigla) LIKE UPPER(?2)", "%"+nome+"%", "%"+sigla+"%").list();
    }
    
}
