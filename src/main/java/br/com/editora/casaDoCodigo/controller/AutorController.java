package br.com.editora.casaDoCodigo.controller;

import br.com.editora.casaDoCodigo.entidades.Autor;
import br.com.editora.casaDoCodigo.entidades.NovoAutor;
import br.com.editora.casaDoCodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/autor")
public class AutorController {


    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @ResponseBody

    public String criar(@RequestBody @Valid NovoAutor novoAutor){
        Autor autor = novoAutor.toModel();
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
