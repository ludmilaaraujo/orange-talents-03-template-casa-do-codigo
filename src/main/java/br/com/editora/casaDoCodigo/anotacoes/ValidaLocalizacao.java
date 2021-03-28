package br.com.editora.casaDoCodigo.anotacoes;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

    @Documented
    @Constraint(validatedBy = {ValidaLocalizacaoValidator.class})
    @Target({FIELD})
    @Retention(RUNTIME)
    public @interface ValidaLocalizacao {
        String message() default "Localizacao invalida";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default { };

    }
