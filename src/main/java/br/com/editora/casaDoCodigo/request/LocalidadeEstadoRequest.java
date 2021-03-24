package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.anotacoes.ExisteEntidade;
import br.com.editora.casaDoCodigo.anotacoes.UniqueValue;
import br.com.editora.casaDoCodigo.entidades.Autor;
import br.com.editora.casaDoCodigo.entidades.LocalidadeEstado;
import br.com.editora.casaDoCodigo.entidades.LocalidadePais;
import br.com.editora.casaDoCodigo.repository.LocalidadePaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LocalidadeEstadoRequest {

    @NotNull @NotBlank
    @UniqueValue(domainClass = LocalidadeEstado.class, fieldName = "nome")
    private String nome;
    @NotNull
    @ExisteEntidade(domainClass = LocalidadePais.class, fieldName = "id")
    private Long idLocalidadePais;

    public LocalidadeEstado converteToEntity(LocalidadePaisRepository localidadePaisRepository){
        LocalidadePais localidadePais = localidadePaisRepository.getOne(this.idLocalidadePais);

        return new LocalidadeEstado(this.nome, localidadePais);
    }

    public LocalidadeEstadoRequest(@NotNull @NotBlank String nome, @NotNull Long idLocalidadePais) {
        this.nome = nome;
        this.idLocalidadePais = idLocalidadePais;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdLocalidadePais() {
        return idLocalidadePais;
    }
}
