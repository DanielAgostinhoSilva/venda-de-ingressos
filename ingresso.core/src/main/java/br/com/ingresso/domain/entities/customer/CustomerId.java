package br.com.ingresso.domain.entities.customer;

import br.com.ingresso.common.domain.value.object.Id;

import java.util.UUID;

public class CustomerId extends Id {

    public CustomerId(UUID id) {
        super(id);
    }
}
