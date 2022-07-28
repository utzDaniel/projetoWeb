package br.com.sinqia.projetoweb.bo;

import br.com.sinqia.projetoweb.dao.LivroDAOI;
import br.com.sinqia.projetoweb.model.Livro;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class LivroBusinessObjectImpl implements LivroBusinessObjectI {

    private LivroDAOI livroDAOI;
    private static long idLivro;

    @Inject
    public LivroBusinessObjectImpl(LivroDAOI livroDAOI) {
        this.livroDAOI = livroDAOI;
    }

    @Override
    public Livro save(Livro livro) {
        livro.setId(idLivro);
        idLivro++;
        return livroDAOI.save(livro);
    }

    @Override
    public List<Livro> findAll() {
        return livroDAOI.findAll();
    }

    @Override
    public void delete(String idLivro) {
        livroDAOI.delete(idLivro);
    }

    @Override
    public Livro getById(String idLivro) {
        Optional<Livro> optionalLivro = livroDAOI.getById(idLivro);
        if (optionalLivro.isPresent()){
            return optionalLivro.get();
        } else {
            throw new IllegalArgumentException("Livro não encontrado para o id: ".concat(idLivro));
        }
    }

    @Override
    public Livro update(Livro livro) {
        Optional<Livro> optionalLivro = livroDAOI.update(livro);
        return optionalLivro.get();
    }
}
