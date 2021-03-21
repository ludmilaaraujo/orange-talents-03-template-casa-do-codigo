package br.com.editora.casaDoCodigo.response;

import br.com.editora.casaDoCodigo.entidades.Autor;

import java.util.List;

public class AutorResposta {

    private String nome;
    private String email;
    private String descricao;

    public AutorResposta() {

    }

    public AutorResposta(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public AutorResposta(List<Autor> autor) {

    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

}
