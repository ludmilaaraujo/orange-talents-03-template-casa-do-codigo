package br.com.editora.casaDoCodigo.entidades;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroPaginas;
    private String isbn;
    private Date dataPublicacao;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Categoria categoria;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Autor autor;

    public Livro(){

    }

    public Livro(String titulo, String resumo, String sumario,
                 Double preco, Integer numeroPaginas, String isbn, Date dataPublicacao,
                 Categoria categoria,
                 Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public String toString() {

        return this.titulo + " " + this.resumo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Long getId() {
        return this.id;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public String getResumo() {
        return this.resumo;
    }

    public String getSumario() {
        return this.sumario;
    }

    public Double getPreco() {
        return this.preco;
    }

    public Integer getNumeroPaginas() {
        return this.numeroPaginas;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public Date getDataPublicacao() {
        return this.dataPublicacao;
    }
}





