package br.com.sinqia.projetoweb.dao;

import br.com.sinqia.projetoweb.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAOI{

    private static List<Livro> bancoLivros = new ArrayList<>();

    @Override
    public Livro save(Livro livro) {
        bancoLivros.add(livro);
        return livro;
    }

    @Override
    public List<Livro> listarAll() {
        return bancoLivros;
    }


}
