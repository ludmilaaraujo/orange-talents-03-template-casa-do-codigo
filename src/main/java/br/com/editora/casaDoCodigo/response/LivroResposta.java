package br.com.editora.casaDoCodigo.response;

import br.com.editora.casaDoCodigo.entidades.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroResposta {
    private Long id;
    private String titulo;

    public LivroResposta() {

    }

    public LivroResposta(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public List<LivroResposta> listaLivros(List<Livro> livros) {

        List<LivroResposta> livroRespostas =  new ArrayList<LivroResposta>();
        for(Livro livro: livros){
            livroRespostas.add(new LivroResposta(livro));
        }

        return livroRespostas;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId(){
        return id;
    }
}
