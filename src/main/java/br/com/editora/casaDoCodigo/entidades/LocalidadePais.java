package br.com.editora.casaDoCodigo.entidades;

import ch.qos.logback.core.joran.conditional.IfAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class LocalidadePais {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy="localidadePais")
    private List<LocalidadeEstado> estados;

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

    public List<LocalidadeEstado> estados() {
        return this.estados;
    }

    public Boolean paisTemEstado() {
        return !estados.isEmpty();
    }
}
