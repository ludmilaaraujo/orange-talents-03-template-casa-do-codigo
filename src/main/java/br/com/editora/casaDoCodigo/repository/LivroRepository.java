package br.com.editora.casaDoCodigo.repository;

import br.com.editora.casaDoCodigo.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {


}
