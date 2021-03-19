package br.com.editora.casaDoCodigo.validacoes;


import br.com.editora.casaDoCodigo.entidades.Autor;
import br.com.editora.casaDoCodigo.request.NovoAutor;
import br.com.editora.casaDoCodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NovoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {

        return NovoAutor.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovoAutor requisicao = (NovoAutor) o;

        Optional<Autor> temEmail = autorRepository.findByEmail(requisicao.getEmail());

        if (temEmail.isPresent()) {
            errors.rejectValue("email", null, "Ja existe o e-mail cadastrado "
                    + requisicao.getEmail());

        }

        Optional<Autor> temNome = autorRepository.findByNome(requisicao.getNome());

        if (temNome.isPresent()) {
            errors.rejectValue("nome", null, "Ja existe esse cliente cadastrado "
                    + requisicao.getNome());

        }
    }
}
