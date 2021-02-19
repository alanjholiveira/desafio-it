package br.com.deliverit.desafio.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe responsável pelo erro de Negócio
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegraNegocioException extends RuntimeException {

    public RegraNegocioException(final String message) {
        this(message, null);
    }

    public RegraNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }


}
