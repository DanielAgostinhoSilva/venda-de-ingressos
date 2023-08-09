package br.com.ingresso.domain.entities.event;

import br.com.ingresso.common.domain.AggregateRoot;
import br.com.ingresso.common.domain.value.object.Name;
import br.com.ingresso.domain.entities.partner.PartnerId;

import java.time.LocalDate;
import java.util.UUID;

public class Event extends AggregateRoot {
    private EventId id;
    private Name name;
    private String description;
    private EventDate date;
    private boolean published;
    private Integer totalSpot;
    private Integer totalSpotReserverd;
    private PartnerId partnerId;

    public Event(
            UUID id,
            String name,
            String description,
            LocalDate date,
            boolean published,
            Integer totalSpot,
            Integer totalSpotReserverd,
            UUID partnerId
    ) {
        this.id = new EventId(id);
        this.name = Name.create(name);
        this.description = description;
        this.date = EventDate.create(date);
        this.published = published;
        this.totalSpot = totalSpot != null ? totalSpot : 0;
        this.totalSpotReserverd = totalSpotReserverd != null ? totalSpotReserverd : 0;
        this.partnerId = new PartnerId(partnerId);
    }

    public static Event create(CreateEventCommand command) {
        return new Event(
                null,
                command.getName(),
                command.getDescription(),
                command.getDate(),
                false,
                0,
                0,
                command.getPartnerId()
        );
    }


    @Override
    public EventId getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public EventDate getDate() {
        return date;
    }

    public boolean isPublished() {
        return published;
    }

    public Integer getTotalSpot() {
        return totalSpot;
    }

    public Integer getTotalSpotReserverd() {
        return totalSpotReserverd;
    }

    public PartnerId getPartnerId() {
        return partnerId;
    }
}
