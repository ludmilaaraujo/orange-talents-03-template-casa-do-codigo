package br.com.editora.casaDoCodigo.response;

import br.com.editora.casaDoCodigo.entidades.Categoria;

public class CategoriaResposta {

    private String nome;
    @Deprecated
    public CategoriaResposta() {

    }

    public CategoriaResposta(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }

}
