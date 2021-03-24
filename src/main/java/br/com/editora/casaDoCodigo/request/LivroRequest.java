package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.anotacoes.ExisteEntidade;
import br.com.editora.casaDoCodigo.anotacoes.UniqueValue;
import br.com.editora.casaDoCodigo.entidades.Autor;
import br.com.editora.casaDoCodigo.entidades.Categoria;
import br.com.editora.casaDoCodigo.entidades.Livro;
import br.com.editora.casaDoCodigo.repository.AutorRepository;
import br.com.editora.casaDoCodigo.repository.CategoriaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class LivroRequest {
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    private Double preco;
    @NotNull
    private Integer numeroPaginas;
    @NotBlank
    private String isbn;
    @NotNull
    private Date dataPublicacao;
    @NotNull
    @ExisteEntidade(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    @NotNull
    @ExisteEntidade(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                        @NotBlank @Size(min = 20) Double preco, @NotBlank Integer numeroPaginas, @NotBlank String isbn,
                        @NotBlank Date dataPublicacao, @NotBlank Long  idCategoria, @NotBlank Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro converteToEntidade(AutorRepository autorRepository,
                                    CategoriaRepository categoriaRepository){

        Categoria categoria = categoriaRepository.getOne(this.idCategoria);
        Autor autor = autorRepository.getOne(this.idAutor);

        return new Livro(this.titulo, this.resumo, this.sumario,
                this.preco, this.numeroPaginas,
                this.isbn, this.dataPublicacao, categoria, autor);
    }

}
