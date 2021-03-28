package br.com.editora.casaDoCodigo.request;

import br.com.editora.casaDoCodigo.anotacoes.ExisteEntidade;
import br.com.editora.casaDoCodigo.anotacoes.UniqueValue;
import br.com.editora.casaDoCodigo.anotacoes.ValidaLocalizacao;
import br.com.editora.casaDoCodigo.entidades.Cliente;
import br.com.editora.casaDoCodigo.entidades.LocalidadeEstado;
import br.com.editora.casaDoCodigo.entidades.LocalidadePais;
import br.com.editora.casaDoCodigo.repository.LocalidadeEstadoRepository;
import br.com.editora.casaDoCodigo.repository.LocalidadePaisRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

public class ClienteRequest {
    @NotNull @Email
    private String email;
    @NotNull
    private String nome;
    @NotNull
    private String sobrenome;
    @NotNull @Size(min = 11 , max = 14)
    @UniqueValue(domainClass = Cliente.class, fieldName = "cpfOrCnpj")
    private String documento;
    @NotNull
    private String endereco;
    @NotNull
    private String complemento;
    @NotNull
    private String cidade;
    @NotNull
    @ValidaLocalizacao
    private LocalizacaoRequest localizacao;
    @NotBlank
    private String telefone;
    @NotNull
    private Double cep;

    public ClienteRequest(@NotNull @Email String email, @NotNull String nome, @NotNull String sobrenome,
                          @NotNull String documento, @NotNull String endereco, @NotNull String complemento,
                          @NotNull String cidade, @NotNull LocalizacaoRequest localizacao,
                          @NotBlank String telefone, @NotNull Double cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.localizacao = localizacao;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente convertToEntity(LocalidadePaisRepository localidadePaisRepository,
                                   LocalidadeEstadoRepository localidadeEstadoRepository) {

        LocalidadePais localidadePais =
                localidadePaisRepository.getOne(this.localizacao.getIdLocalidadePais());
        if (localidadePais.paisTemEstado()){
            if (this.localizacao.getIdLocalidadeEstado() != null) {
                LocalidadeEstado localidadeEstado
                        = localidadeEstadoRepository.getOne(this.localizacao.getIdLocalidadeEstado());
                return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                        this.complemento, this.cidade, localidadePais, localidadeEstado, this.telefone,
                        this.cep);
            }
        }
        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                this.complemento, this.cidade, localidadePais, null, this.telefone,
                this.cep);


    }





}
