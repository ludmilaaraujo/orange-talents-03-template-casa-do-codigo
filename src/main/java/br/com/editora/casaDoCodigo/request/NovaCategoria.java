package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.entidades.Categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoria {

    @NotBlank
    private String nome;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
//
//    public NovaCategoriaRequest(String nome) {
//        this.nome = nome;
//
//    }
//    public String getNome() {
//        return nome;
////    }
//
    public Categoria categoriaDTO(){
        return new Categoria(this.nome);

    }

}
