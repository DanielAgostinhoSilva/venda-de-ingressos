package br.com.ingresso.domain.entities.partner;

import br.com.ingresso.common.domain.AggregateRoot;
import br.com.ingresso.common.domain.value.object.Name;
import br.com.ingresso.domain.entities.event.CreateEventCommand;
import br.com.ingresso.domain.entities.event.Event;
import br.com.ingresso.domain.entities.event.InitEventCommand;

import java.util.UUID;

public class Partner extends AggregateRoot {
    private PartnerId id;
    private Name name;

    public Partner(UUID id, String name) {
        this.id = new PartnerId(id);
        this.name = Name.create(name);
    }

    public static Partner create(String name) {
        return new Partner(UUID.randomUUID(), name);
    }

    public Event initiEvent(InitEventCommand command) {
        return Event.create(new CreateEventCommand(
                command.getName(),
                command.getDescription(),
                command.getDate(),
                this.id.getValue())
        );
    }

    public void changeName(String name) {
        this.name = Name.create(name);
    }


    @Override
    public PartnerId getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
