package br.com.editora.casaDoCodigo.response;

import br.com.editora.casaDoCodigo.entidades.Livro;

import java.util.Date;

public class LivroRespostaDetalhe {    
      
        private String titulo;
        private String resumo;
        private String sumario;
        private Double preco;
        private Integer numeroPaginas;
        private String isbn;
        private Date dataPublicacao;
        private AutorResposta autor;

    public LivroRespostaDetalhe(Livro livro) {
       titulo = livro.getTitulo();
       resumo = livro.getResumo();
       sumario = livro.getSumario();
       preco = livro.getPreco();
       numeroPaginas = livro.getNumeroPaginas();
       isbn = livro.getIsbn();
       dataPublicacao = livro.getDataPublicacao();
       autor = new AutorResposta(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorResposta getAutor() {
        return autor;
    }
}
