package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.entidades.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NovoAutor {


    @NotNull @NotEmpty
    private String nome;

    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;    }

    @NotNull @NotEmpty @Email
    private String email;
    @NotNull@NotEmpty@Size(max=400)
    private String descricao;

    public NovoAutor(@NotNull @NotEmpty String nome,
                     @NotNull @NotEmpty @Email String email,
                     @NotNull @NotEmpty @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;    }


    public Autor autorDTO(){
        return new Autor(this.nome,this.email,this.descricao);

    }
}
