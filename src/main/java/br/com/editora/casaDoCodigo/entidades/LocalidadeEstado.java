package br.com.editora.casaDoCodigo.entidades;

import br.com.editora.casaDoCodigo.anotacoes.UniqueValue;

import javax.persistence.*;

@Entity
public class LocalidadeEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne(cascade = CascadeType.DETACH)
    private LocalidadePais localidadePais;

    public LocalidadeEstado(String nome, LocalidadePais localidadePais) {
        this.nome = nome;
        this.localidadePais = localidadePais;
    }

    @Override
    public  String toString() {

        return "LocalidadeEstado [nome=" + nome + "]";
    }

    public String getNome() {
        return nome;
    }

    public LocalidadePais getLocalidadePais() {
        return localidadePais;
    }

}
