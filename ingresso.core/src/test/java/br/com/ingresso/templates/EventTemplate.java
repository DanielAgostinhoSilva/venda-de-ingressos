package br.com.ingresso.templates;

import br.com.ingresso.domain.entities.event.Event;
import br.com.ingresso.domain.entities.event.EventSection;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class EventTemplate {

    public static Event valido() {
        return new Event(
                UUID.fromString("c86120f7-2f48-4b28-9e95-ebc881757f6d"),
                "Event A",
                 "Event description A",
                LocalDate.of(2023, 8, 8),
                false,
                0,
                0,
                UUID.fromString("c289bacb-5d11-434d-8454-7886f99d47de"),
                new HashSet<>()
        );
    }

    public static Event validoComEventSection() {

        var sections = new HashSet<EventSection>();
        sections.add(EventSectionTemplate.validoComSpot());

        return new Event(
                UUID.fromString("c86120f7-2f48-4b28-9e95-ebc881757f6d"),
                "Event A",
                "Event description A",
                LocalDate.of(2023, 8, 8),
                false,
                0,
                0,
                UUID.fromString("c289bacb-5d11-434d-8454-7886f99d47de"),
                sections
        );
    }
}
