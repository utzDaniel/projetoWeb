package br.com.sinqia.projetoweb.dao;

import br.com.sinqia.projetoweb.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAOImpl implements LivroDAOI{

    private static List<Livro> bancoLivros = new ArrayList<>();

    @Override
    public Livro save(Livro livro) {
        bancoLivros.add(livro);
        return livro;
    }

    @Override
    public List<Livro> findAll() {
        return bancoLivros;
    }

    @Override
    public void delete(String idLivro) {
        for (Livro livro: bancoLivros) {
            if (livro.getId().equals(Long.valueOf(idLivro))){
                bancoLivros.remove(livro);
                break;
            }
        }
    }

    @Override
    public Optional<Livro> getById(String idLivro) {
        for (Livro livro: bancoLivros) {
            if (livro.getId().equals(Long.valueOf(idLivro))){
                return Optional.of(livro);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Livro> update(Livro livro) {
        for (Livro updateLivro : bancoLivros) {
            if (updateLivro.getId().equals(livro.getId())){
                updateLivro(updateLivro, livro);
                return Optional.of(updateLivro);
            }
        }
        return Optional.empty();
    }

    private void updateLivro(Livro updateLivro, Livro livro) {
        updateLivro.setNome(livro.getNome());
        updateLivro.setAutor(livro.getAutor());
    }
}
