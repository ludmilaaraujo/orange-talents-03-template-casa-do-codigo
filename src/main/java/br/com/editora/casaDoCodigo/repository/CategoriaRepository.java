package br.com.editora.casaDoCodigo.repository;

import br.com.editora.casaDoCodigo.entidades.Autor;
import br.com.editora.casaDoCodigo.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

        Optional<Categoria> findByNome(String nome);

}
