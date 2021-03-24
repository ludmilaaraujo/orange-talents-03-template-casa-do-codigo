package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.anotacoes.UniqueValue;
import br.com.editora.casaDoCodigo.entidades.LocalidadePais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LocalidadePaisRequest {

    @NotNull @NotBlank
    @UniqueValue(domainClass = LocalidadePais.class, fieldName = "nome")
    private String nome;


    public String getNome() {
        return nome;
    }

    public LocalidadePais convertoToEntity(){
        return new LocalidadePais(this.nome);
    }
}
