package br.com.ingresso.domain.entities.event;

import br.com.ingresso.common.domain.Entity;
import br.com.ingresso.common.domain.value.object.Name;

import java.math.BigDecimal;
import java.util.UUID;

public class EventSpot extends Entity {
    private EventSpotId id;
    private String location;
    private boolean reserverd;
    private boolean published;

    public EventSpot(UUID id, String location, boolean reserverd, boolean published) {
        this.id = new EventSpotId(id);
        this.location = location;
        this.reserverd = reserverd;
        this.published = published;
    }

    public static EventSpot create() {
        return new EventSpot(
                null,
                "",
                false,
                false
        );
    }

    public void changeLocation(String location) {
        this.location = location;
    }

    public void publish() {
        this.published = true;
    }

    public void unPublish() {
        this.published = false;
    }

    @Override
    public EventSpotId getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public boolean isReserverd() {
        return reserverd;
    }

    public boolean isPublished() {
        return published;
    }

    @Override
    public String toString() {
        return "EventSpot{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", reserverd=" + reserverd +
                ", published=" + published +
                '}';
    }
}
