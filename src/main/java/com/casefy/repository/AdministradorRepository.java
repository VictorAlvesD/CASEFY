package com.casefy.repository;

import java.util.List;

import com.casefy.model.Administrador;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdministradorRepository implements PanacheRepository<Administrador>{
    @SuppressWarnings("unchecked")
    public List<Administrador> findByNome(String nome){
        if(nome ==null){
            return null;
        }
        return (List<Administrador>) find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase() + "%").list();
    }
    /* 
    public List<Administrador> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome+"%").list();
    }*/
    public Administrador findByMatricula(Integer matricula) {
        return find("matricula = ?1", matricula).firstResult();
    }
    
}
