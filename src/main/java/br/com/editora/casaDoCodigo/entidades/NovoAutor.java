package br.com.editora.casaDoCodigo.entidades;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.validation.constraints.*;

public class NovoAutor {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull@NotEmpty@Size(max=400)
    private String descricao;

    public NovoAutor(@NotNull @NotEmpty String nome,
                     @NotNull @NotEmpty @Email String email,
                     @NotNull @NotEmpty @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }


    public Autor toModel(){
        return new Autor(this.nome,this.email,this.descricao);

    }
}
