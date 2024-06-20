package com.casefy.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;

import com.casefy.model.Usuario;
import com.casefy.resource.TelefoneResource;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    private static final Logger LOG = Logger.getLogger(TelefoneResource.class);

    public List<Usuario> findByNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            LOG.warn("Nome vazio ou nulo fornecido para findByNome");
            return Collections.emptyList();
        }
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();
    }

    public PanacheQuery<Usuario> findByLogin(String login) {
        if (login == null || login.isEmpty()) {
            LOG.warn("Login vazio ou nulo fornecido para findByLogin");
            return null;
        }
        return find("login = ?1", login);
    }

    public PanacheQuery<Usuario> findByLoginAndSenha(String login, String senha) {
        if (login == null || login.isEmpty() || senha == null || senha.isEmpty()) {
            LOG.warn("Login ou senha vazios ou nulos fornecidos para findByLoginAndSenha");
            return null;
        }
        return find("login = ?1 AND senha = ?2", login, senha);
    }
}
