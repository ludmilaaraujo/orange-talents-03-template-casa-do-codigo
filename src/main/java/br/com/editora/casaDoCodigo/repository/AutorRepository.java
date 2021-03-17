package br.com.editora.casaDoCodigo.repository;

import br.com.editora.casaDoCodigo.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
