package br.com.editora.casaDoCodigo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocalidadePais {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public LocalidadePais(String nome) {
       this.nome = nome;
    }

    @Override
    public  String toString() {

        return "LocalidadePais [nome=" + nome + "]";
    }

    @Deprecated
    public LocalidadePais(){

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
