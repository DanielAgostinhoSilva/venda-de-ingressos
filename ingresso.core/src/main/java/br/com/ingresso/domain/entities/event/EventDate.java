package br.com.ingresso.domain.entities.event;

import br.com.ingresso.common.domain.value.object.ValueObject;
import br.com.ingresso.domain.exception.InvalidEventException;

import java.time.LocalDate;

public class EventDate extends ValueObject<LocalDate> {

    private EventDate(LocalDate date) {
        super(date);
    }

    public static EventDate create(LocalDate date) {
        if (date == null) {
            throw new InvalidEventException("Event date is required");
        }
        return new EventDate(date);
    }
}
