package br.com.editora.casaDoCodigo.entidades;
import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    private String sobrenome;
    private String cpfOrCnpj;
    private String endereco;
    private String complemento;
    private String cidade;
    @ManyToOne(cascade = CascadeType.DETACH)
    private LocalidadePais localidadePais;
    @ManyToOne(cascade = CascadeType.DETACH)
    private LocalidadeEstado localidadeEstado;
    private String telefone;
    private Double cep;


    public Cliente(String email, String nome, String sobrenome, String cpfOrCnpj,
                   String endereco, String complemento, String cidade,
                   LocalidadePais localidadePais, LocalidadeEstado localidadeEstado,
                   String telefone, Double cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfOrCnpj = cpfOrCnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.localidadePais = localidadePais;
        this.localidadeEstado = localidadeEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Override
    public String toString(){
        return this.nome + "" + this.email;
    }


    public Cliente(){

    }
}
