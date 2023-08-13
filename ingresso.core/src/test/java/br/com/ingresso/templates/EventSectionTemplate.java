package br.com.ingresso.templates;

import br.com.ingresso.domain.entities.event.EventSection;
import br.com.ingresso.domain.entities.event.EventSpot;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.UUID;

public class EventSectionTemplate {

    public static EventSection valido() {
        return new EventSection(
                UUID.fromString("8e501a8f-0ba9-44be-8664-51d5725fb374"),
                "Event Section A",
                "Event Section description",
                false,
                0,
                0,
                new BigDecimal(0.0),
                new HashSet<>()
        );
    }

    public static EventSection validoComSpot() {
        var spots = new HashSet<EventSpot>();
        spots.add(EventSpot.create());

        return new EventSection(
                UUID.fromString("8e501a8f-0ba9-44be-8664-51d5725fb374"),
                "Event Section A",
                "Event Section description",
                false,
                0,
                0,
                new BigDecimal(0.0),
                spots
        );
    }
}
