package br.com.ingresso.domain.entities.event;

import br.com.ingresso.common.domain.value.object.Name;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class CreateEventSectionCommand {
    private String name;
    private String description;
    private Integer totalSpot;
    private BigDecimal price;

    public CreateEventSectionCommand(){}

    public CreateEventSectionCommand(String name, String description, Integer totalSpot, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.totalSpot = totalSpot;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalSpot() {
        return totalSpot;
    }

    public void setTotalSpot(Integer totalSpot) {
        this.totalSpot = totalSpot;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
