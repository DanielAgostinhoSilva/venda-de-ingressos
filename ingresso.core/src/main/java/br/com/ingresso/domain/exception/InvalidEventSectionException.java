package br.com.ingresso.domain.exception;

import br.com.ingresso.common.domain.exception.BussinessException;

public class InvalidEventSectionException extends BussinessException {
    public InvalidEventSectionException(String message) {
        super(message);
    }
}
