package br.com.ingresso.domain.entities.event;

import java.math.BigDecimal;

public class AddSectionCommand {
    private String name;
    private String description;
    private Integer totalSpot;
    private BigDecimal price;

    public AddSectionCommand(){}

    public AddSectionCommand(String name, String description, Integer totalSpot, BigDecimal price) {
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
