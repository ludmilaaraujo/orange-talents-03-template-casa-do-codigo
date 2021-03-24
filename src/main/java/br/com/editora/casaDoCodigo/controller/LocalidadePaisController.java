package br.com.editora.casaDoCodigo.controller;


import br.com.editora.casaDoCodigo.entidades.LocalidadePais;
import br.com.editora.casaDoCodigo.repository.LocalidadePaisRepository;
import br.com.editora.casaDoCodigo.request.LocalidadePaisRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LocalidadePaisController {

    @Autowired
    private LocalidadePaisRepository localidadePaisRepository;

    @PostMapping(value = "/localidadePais")
    @Transactional
    public String LocalidadePaisRetorno(@RequestBody @Valid LocalidadePaisRequest localidadePaisRequest){
        LocalidadePais localidadePais1 = localidadePaisRequest.convertoToEntity();
        localidadePaisRepository.save(localidadePais1);

        return localidadePais1.toString();
    }
}
