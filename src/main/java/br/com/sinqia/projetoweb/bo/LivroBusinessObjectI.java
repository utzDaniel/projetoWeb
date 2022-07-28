package br.com.sinqia.projetoweb.bo;

import java.util.List;
import br.com.sinqia.projetoweb.model.Livro;


public interface LivroBusinessObjectI {

    Livro save(Livro livro);

    List<Livro> findAll();

    void delete(String idLivro);

    Livro getById(String idLivro);

    Livro update(Livro livro);
}
