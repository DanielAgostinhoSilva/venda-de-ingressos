package br.com.ingresso.common.domain.value.object;

import br.com.ingresso.common.domain.exception.InvalidIdException;

import java.util.UUID;

public class Id extends ValueObject<UUID> {
    private static final String INVALID_ID = "Invalid ID";

    public Id(UUID id) {
        super(id != null ? id : UUID.randomUUID());
    }

}
