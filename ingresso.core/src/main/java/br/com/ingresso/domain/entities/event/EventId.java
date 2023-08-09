package br.com.ingresso.domain.entities.event;

import br.com.ingresso.common.domain.value.object.Id;

import java.util.UUID;

public class EventId extends Id {

    public EventId(UUID id) {
        super(id);
    }
}
