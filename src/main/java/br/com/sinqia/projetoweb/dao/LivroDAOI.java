package br.com.sinqia.projetoweb.dao;

import br.com.sinqia.projetoweb.model.Livro;

import java.util.List;

public interface LivroDAOI {

    Livro save(Livro livro);

    List<Livro> listarAll();
}
