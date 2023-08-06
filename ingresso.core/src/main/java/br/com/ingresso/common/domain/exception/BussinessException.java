package br.com.ingresso.common.domain.exception;

public class BussinessException extends RuntimeException{
    public BussinessException(String message) {
        super(message);
    }
}
