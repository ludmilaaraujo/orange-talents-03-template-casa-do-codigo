package br.com.editora.casaDoCodigo.validacoes;

import br.com.editora.casaDoCodigo.entidades.Categoria;
import br.com.editora.casaDoCodigo.request.NovaCategoria;
import br.com.editora.casaDoCodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
@Component
public class NovaCategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {

        return NovaCategoria.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovaCategoria categoriaRequest = (NovaCategoria) o;


        Optional<Categoria> temNome = categoriaRepository.findByNome(categoriaRequest.getNome());

        if (temNome.isPresent()) {
            errors.rejectValue("nome", null, "Ja existe essa categoria cadastrada "
                    + categoriaRequest.getNome());

        }
    }
}
