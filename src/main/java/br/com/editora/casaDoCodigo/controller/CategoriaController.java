package br.com.editora.casaDoCodigo.controller;

import br.com.editora.casaDoCodigo.entidades.Categoria;
import br.com.editora.casaDoCodigo.request.NovaCategoria;
import br.com.editora.casaDoCodigo.repository.CategoriaRepository;
import br.com.editora.casaDoCodigo.validacoes.NovaCategoriaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private NovaCategoriaValidator novaCategoriaValidator;


//    @InitBinder
//    public void init(WebDataBinder binder) {
//        binder.addValidators(novaCategoriaValidator);
//    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(novaCategoriaValidator);
    }

    @PostMapping(value = "/categorias")
    @Transactional
    public String criar(@RequestBody @Valid NovaCategoria novaCategoria) {

        Categoria novacategoria = novaCategoria.categoriaDTO();
        categoriaRepository.save(novacategoria);
        return novacategoria.toString();

    }
}
