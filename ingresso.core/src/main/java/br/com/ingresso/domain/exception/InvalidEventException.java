package br.com.ingresso.domain.exception;

import br.com.ingresso.common.domain.exception.BussinessException;

public class InvalidEventException extends BussinessException {
    public InvalidEventException(String message) {
        super(message);
    }
}
