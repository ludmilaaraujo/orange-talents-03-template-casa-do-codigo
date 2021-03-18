package br.com.editora.casaDoCodigo.repository;

import br.com.editora.casaDoCodigo.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

    Optional<Autor> findByNome(String nome);

}
