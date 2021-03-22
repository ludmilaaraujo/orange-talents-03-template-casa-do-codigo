package br.com.editora.casaDoCodigo.controller;

import br.com.editora.casaDoCodigo.entidades.Livro;
import br.com.editora.casaDoCodigo.repository.AutorRepository;
import br.com.editora.casaDoCodigo.repository.CategoriaRepository;
import br.com.editora.casaDoCodigo.repository.LivroRepository;
import br.com.editora.casaDoCodigo.request.NovoLivro;
import br.com.editora.casaDoCodigo.response.LivroResposta;
import br.com.editora.casaDoCodigo.response.LivroRespostaDetalhe;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping(value = "/livro")
    @Transactional
    public String novoLivro(@RequestBody @Valid NovoLivro novoLivro) {
        Livro livro = novoLivro.converteToEntidade(autorRepository, categoriaRepository);
        livroRepository.save(livro);
        return livro.toString();
    }
    @GetMapping(value = "/livro")
    @ResponseBody
    public List<LivroResposta> listaLivro() {

       List<Livro> livros = livroRepository.findAll();

      return new LivroResposta().listaLivros(livros);
    }

    @GetMapping(value = "/livro/{id}")
    public ResponseEntity <LivroRespostaDetalhe> livroExibido(@PathVariable("id") Long id){

        Optional<Livro> livro = livroRepository.findById(id);
        if(!livro.isPresent()){
            return ResponseEntity.notFound().build();
        }

        LivroRespostaDetalhe livroResposta = new LivroRespostaDetalhe(livro.get());
        return ResponseEntity.ok(livroResposta);
    }


}
