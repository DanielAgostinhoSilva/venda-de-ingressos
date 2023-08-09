package br.com.ingresso.domain.entities.event;

import br.com.ingresso.common.domain.Entity;
import br.com.ingresso.common.domain.value.object.Name;

import java.math.BigDecimal;
import java.util.UUID;

public class EventSection extends Entity {
    private EventSectionId id;
    private Name name;
    private String description;
    private boolean published;
    private Integer totalSpot;
    private Integer totalSpotReserverd;
    private BigDecimal price;

    public EventSection(
            UUID id,
            String name,
            String description,
            boolean published,
            Integer totalSpot,
            Integer totalSpotReserverd,
            BigDecimal price
    ) {
        this.id = new EventSectionId(id);
        this.name = Name.create(name);
        this.description = description;
        this.published = published;
        this.totalSpot = totalSpot != null ? totalSpot : 0;
        this.totalSpotReserverd = totalSpotReserverd != null ? totalSpotReserverd : 0;
        this.price = price;
    }

    public static EventSection create(CreateEventSectionCommand command) {
        return new EventSection(
                null,
                command.getName(),
                command.getDescription(),
                false,
                command.getTotalSpot(),
                0,
                command.getPrice()
        );
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
}
