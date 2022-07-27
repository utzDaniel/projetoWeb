package br.com.sinqia.projetoweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Livro {

    private String nome;
    private String autor;
}
