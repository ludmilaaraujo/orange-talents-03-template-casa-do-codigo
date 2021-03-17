package br.com.editora.casaDoCodigo.controller;

import br.com.editora.casaDoCodigo.entidades.Autor;
import br.com.editora.casaDoCodigo.entidades.NovoAutor;
import br.com.editora.casaDoCodigo.repository.AutorRepository;
import br.com.editora.casaDoCodigo.validacoes.NovoAutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private NovoAutorValidator novoAutorValidator;


    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(novoAutorValidator);
    }

    @PostMapping
    @Transactional
    public String criar(@RequestBody @Valid NovoAutor novoAutor){
        Autor autor = novoAutor.autorDTO();
        autorRepository.save(autor);
        return autor.toString();

    }


//    @DeleteMapping
//    @ResponseBody
//    public void excluir(Autor autor) {
//        autorRepository.delete(autor);
//    }
//
//    @PutMapping
//    @ResponseBody
//    public Autor atualizar(){
//        return null;
//    }

//    @GetMapping
//    @ResponseBody
//    public Autor ler(){
//        return new Autor(null, null, null);
//    }
//    @GetMapping("/listar")
//    @ResponseBody
//    public List<Autor> lista(){
//        return null;
//    }
//
}
