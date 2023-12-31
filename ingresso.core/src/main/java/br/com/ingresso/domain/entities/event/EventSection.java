package br.com.ingresso.domain.entities.event;

import br.com.ingresso.common.domain.Entity;
import br.com.ingresso.common.domain.value.object.Name;
import br.com.ingresso.domain.exception.InvalidEventException;
import br.com.ingresso.domain.exception.InvalidEventSectionException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class EventSection extends Entity {
    private EventSectionId id;
    private Name name;
    private String description;
    private boolean published;
    private Integer totalSpot;
    private Integer totalSpotReserverd;
    private BigDecimal price;
    private Set<EventSpot> spots;

    public EventSection(
            UUID id,
            String name,
            String description,
            boolean published,
            Integer totalSpot,
            Integer totalSpotReserverd,
            BigDecimal price,
            Set<EventSpot> spots
    ) {
        this.id = new EventSectionId(id);
        this.name = Name.create(name);
        this.description = description;
        this.published = published;
        this.totalSpot = totalSpot != null ? totalSpot : 0;
        this.totalSpotReserverd = totalSpotReserverd != null ? totalSpotReserverd : 0;
        this.price = price;
        this.spots = spots != null ? spots : new HashSet<>();
    }

    public static EventSection create(CreateEventSectionCommand command) {
        var spot = new HashSet<EventSpot>();
        for (int i = 0; i < command.getTotalSpot(); i++) {
            spot.add(EventSpot.create());
        }

        return new EventSection(
                null,
                command.getName(),
                command.getDescription(),
                false,
                command.getTotalSpot(),
                0,
                command.getPrice(),
                spot
        );
    }

    public void changeName(String name) {
        this.name = Name.create(name);
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changePrince(BigDecimal price) {
        if(price == null) {
            throw new InvalidEventSectionException("Price can not be null");
        }
        if(price.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidEventSectionException(String.format("Invalid price %s", price));
        }
        this.price = price;
    }

    public void publishAll() {
        this.publish();
        this.spots.forEach(EventSpot::publish);
    }

    public void publish() {
        this.published = true;
    }

    public void unPublish() {
        this.published = false;
    }

    @Override
    public EventSectionId getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public BigDecimal getPrice() {
        return price;
    }

    public Set<EventSpot> getSpots() {
        return spots;
    }

    @Override
    public String toString() {
        return "EventSection{" +
                "id=" + id +
                ", name=" + name +
                ", description='" + description + '\'' +
                ", published=" + published +
                ", totalSpot=" + totalSpot +
                ", totalSpotReserverd=" + totalSpotReserverd +
                ", price=" + price +
                ", spots=" + spots +
                '}';
    }
}
