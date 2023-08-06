package br.com.ingresso.common.domain.value.object;

import br.com.ingresso.common.domain.exception.InvalidNameException;

public class Name extends ValueObject<String>{
    private static final String NAME_IS_REQUIRED = "Name is required";
    private static final String INVALID_NAME = "Invalid Name";

    private Name(String value) {
        super(value);
    }

    public static Name create(String name) {
        if(name == null) {
            throw new InvalidNameException(NAME_IS_REQUIRED);
        }

        if(name.length() < 3) {
            throw new InvalidNameException(INVALID_NAME);
        }

        return new Name(name);
    }
}
