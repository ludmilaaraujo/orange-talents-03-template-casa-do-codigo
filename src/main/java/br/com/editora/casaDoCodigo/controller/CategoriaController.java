package br.com.editora.casaDoCodigo.controller;

import br.com.editora.casaDoCodigo.entidades.Categoria;
import br.com.editora.casaDoCodigo.repository.CategoriaRepository;
import br.com.editora.casaDoCodigo.request.NovaCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
//    @Autowired
//    private NovaCategoriaValidator novaCategoriaValidator;


//    @InitBinder
//    public void init(WebDataBinder binder) {
//        binder.addValidators(novaCategoriaValidator);
//    }
//
//    @InitBinder
//    public void init(WebDataBinder binder){
//        binder.addValidators(novaCategoriaValidator);
//    }

    @PostMapping(value = "/categoria")
    @Transactional
    public String criar(@RequestBody @Valid NovaCategoria novaCategoria) {

        Categoria novacategoria = novaCategoria.converteToEntidade();
        categoriaRepository.save(novacategoria);
        return novacategoria.toString();
    }

}
