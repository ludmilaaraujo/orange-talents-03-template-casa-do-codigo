package br.com.editora.casaDoCodigo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime instante = LocalDateTime.now();

    public Autor(String nome, String email,
                 String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
    @Deprecated
    public Autor(){

    }

    @Override
    public  String toString(){
        return "Autor [nome=" + nome
                + ", email=" + email + ", " +
                "descricao= " + descricao +"]";
        }
    }
