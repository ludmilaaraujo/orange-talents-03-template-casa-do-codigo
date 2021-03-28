package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.anotacoes.DataMaior;
import br.com.editora.casaDoCodigo.anotacoes.NumeroMaior;
import br.com.editora.casaDoCodigo.anotacoes.UniqueValue;
import br.com.editora.casaDoCodigo.entidades.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;
    @DataMaior
    private Date data;
    @NumeroMaior
    private Integer numero;

    public CategoriaRequest(@NotBlank String nome, @NotNull Date data, Integer numero) {
        this.nome = nome;
        this.data = data;
        this.numero = numero;
    }

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
