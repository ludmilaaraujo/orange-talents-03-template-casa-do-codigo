package br.com.editora.casaDoCodigo.repository;

import br.com.editora.casaDoCodigo.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
