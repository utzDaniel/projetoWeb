package br.com.sinqia.projetoweb.dao;

import br.com.sinqia.projetoweb.model.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroDAOI {

    Livro save(Livro livro);

    List<Livro> findAll();

    void delete(String idLivro);

    Optional<Livro> getById(String idLivro);

    Optional<Livro> update(Livro livro);
}
