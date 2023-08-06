package br.com.ingresso.domain.exception;

import br.com.ingresso.common.domain.exception.BussinessException;

public class InvalidCustomerException extends BussinessException {
    public InvalidCustomerException(String message) {
        super(message);
    }
}
