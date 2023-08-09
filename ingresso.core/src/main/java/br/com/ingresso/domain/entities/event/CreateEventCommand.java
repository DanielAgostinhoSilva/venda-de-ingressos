package br.com.ingresso.domain.entities.event;

import java.time.LocalDate;
import java.util.UUID;

public class CreateEventCommand {
    private String name;
    private String description;
    private LocalDate date;
    private UUID partnerId;

    public CreateEventCommand(){}

    public CreateEventCommand(String name, String description, LocalDate date, UUID partnerId) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.partnerId = partnerId;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(UUID partnerId) {
        this.partnerId = partnerId;
    }
}
