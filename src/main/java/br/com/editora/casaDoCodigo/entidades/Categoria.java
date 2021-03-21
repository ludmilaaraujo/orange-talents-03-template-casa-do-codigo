package br.com.editora.casaDoCodigo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;

    public Categoria(@NotBlank String nome) {
       this.nome = nome;
    }

    @Deprecated
    public Categoria(){
    }

    @Override
    public  String toString() {
        return "Categoria [nome=" + nome + "]";
    }

    public String getNome() {
        return nome;
    }
}