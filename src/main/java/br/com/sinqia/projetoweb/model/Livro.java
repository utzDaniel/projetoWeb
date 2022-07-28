package br.com.sinqia.projetoweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Livro {

    private String nome;
    private String autor;
    private Long id;

    public Livro(String nome, String autor) {
        this.nome = nome;
        this.autor = autor;
    }
}
