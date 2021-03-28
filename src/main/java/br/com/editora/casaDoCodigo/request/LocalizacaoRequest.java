package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.anotacoes.ExisteEntidade;
import br.com.editora.casaDoCodigo.entidades.Categoria;
import br.com.editora.casaDoCodigo.entidades.LocalidadePais;

import javax.validation.constraints.NotNull;

public class LocalizacaoRequest {
    @NotNull
    private Long idLocalidadePais;
    private Long idLocalidadeEstado;

    public LocalizacaoRequest(Long idLocalidadeEstado, @NotNull Long idLocalidadePais) {
        this.idLocalidadeEstado = idLocalidadeEstado;
        this.idLocalidadePais = idLocalidadePais;
    }

    public Long getIdLocalidadePais() {
        return idLocalidadePais;
    }

    public Long getIdLocalidadeEstado() {
        return idLocalidadeEstado;
    }
}
