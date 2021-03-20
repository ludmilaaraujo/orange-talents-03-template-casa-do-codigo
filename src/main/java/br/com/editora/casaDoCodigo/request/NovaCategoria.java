package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.anotacoes.UniqueValue;
import br.com.editora.casaDoCodigo.entidades.Categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoria {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
    public Categoria converteToEntidade(){
        return new Categoria(this.nome);

    }

}
