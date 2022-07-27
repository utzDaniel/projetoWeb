package br.com.sinqia.projetoweb.bo;

import br.com.sinqia.projetoweb.dao.LivroDAOI;
import br.com.sinqia.projetoweb.dao.LivroDAOImpl;
import br.com.sinqia.projetoweb.model.Livro;

import javax.inject.Inject;
import java.util.List;

public class LivroBusinessObjectImpl implements LivroBusinessObjectI {

    private LivroDAOI livroDAOI;

    @Inject
    public LivroBusinessObjectImpl(LivroDAOI livroDAOI) {
        this.livroDAOI = livroDAOI;
    }

    @Override
    public Livro save(Livro livro) {
        return livroDAOI.save(livro);
    }

    @Override
    public List<Livro> listarAll() {
        return livroDAOI.listarAll();
    }
}
