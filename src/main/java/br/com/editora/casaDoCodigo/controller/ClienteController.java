package br.com.editora.casaDoCodigo.controller;

import br.com.editora.casaDoCodigo.entidades.Cliente;
import br.com.editora.casaDoCodigo.repository.ClienteRepository;
import br.com.editora.casaDoCodigo.repository.LocalidadeEstadoRepository;
import br.com.editora.casaDoCodigo.repository.LocalidadePaisRepository;
import br.com.editora.casaDoCodigo.request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LocalidadeEstadoRepository localidadeEstadoRepository;

    @Autowired
    private LocalidadePaisRepository localidadePaisRepository;

    @PostMapping (value = "/cliente")
    @Transactional
    public String clienteRequest1 (@RequestBody @Valid ClienteRequest clienteRequest)  {
        Cliente cliente = clienteRequest.convertToEntity(localidadePaisRepository, localidadeEstadoRepository);
        clienteRepository.save(cliente);
        return cliente.toString();
    }

}
