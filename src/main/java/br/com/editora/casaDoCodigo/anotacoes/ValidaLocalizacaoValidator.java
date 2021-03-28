package br.com.editora.casaDoCodigo.anotacoes;

import br.com.editora.casaDoCodigo.entidades.LocalidadePais;
import br.com.editora.casaDoCodigo.repository.LocalidadePaisRepository;
import br.com.editora.casaDoCodigo.request.LocalizacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidaLocalizacaoValidator implements ConstraintValidator<ValidaLocalizacao, Object> {

    @Autowired
    private LocalidadePaisRepository localidadePaisRepository;

    @Override
    public void initialize(ValidaLocalizacao params){

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        LocalizacaoRequest localizacaoRequest = (LocalizacaoRequest) o;
        Optional<LocalidadePais> localidadePais
                = localidadePaisRepository.findById(localizacaoRequest.getIdLocalidadePais());
        if (localidadePais.isPresent()
                && localidadePais.get().paisTemEstado()
                && localizacaoRequest.getIdLocalidadeEstado() == null){
            return false;
        }
        return true;
    }

}
