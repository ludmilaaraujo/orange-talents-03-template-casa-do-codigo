package br.com.editora.casaDoCodigo.controller;

import br.com.editora.casaDoCodigo.entidades.LocalidadeEstado;
import br.com.editora.casaDoCodigo.repository.LocalidadeEstadoRepository;
import br.com.editora.casaDoCodigo.repository.LocalidadePaisRepository;
import br.com.editora.casaDoCodigo.request.LocalidadeEstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LocalidadeEstadoController {

    @Autowired
    private LocalidadePaisRepository localidadePaisRepository;

    @Autowired
    private LocalidadeEstadoRepository localidadeEstadoRepository;

    @PostMapping(value = "/localidadeEstado")
    @Transactional
    public String localizacaoEstadoRetorno(@RequestBody @Valid LocalidadeEstadoRequest localidadeEstadoRequest){

        LocalidadeEstado localidadeEstado = localidadeEstadoRequest.converteToEntity(localidadePaisRepository);
        localidadeEstadoRepository.save(localidadeEstado);
        return localidadeEstado.toString();
    }

}
