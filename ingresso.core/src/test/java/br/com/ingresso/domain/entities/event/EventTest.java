package br.com.ingresso.domain.entities.event;

import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void deve_permitir_copia_os_atributos_de_um_evento() {
        UUID eventId = UUID.randomUUID();
        String name = "Event A";
        String description = null;
        LocalDate eventDate = LocalDate.now();
        boolean published = false;
        Integer totalSpot = 0;
        Integer totalSpotReserverd = 0;
        UUID partnerId = UUID.randomUUID();

        Event event = new Event(
                eventId,
                name,
                description,
                eventDate,
                published,
                totalSpot,
                totalSpotReserverd,
                partnerId
        );

        assertNotNull(event);
        assertEquals(eventId, event.getId().getValue());
        assertEquals(name, event.getName().getValue());
        assertEquals(description, event.getDescription());
        assertEquals(eventDate, event.getDate().getValue());
        assertEquals(published, event.isPublished());
        assertEquals(totalSpot, event.getTotalSpot());
        assertEquals(totalSpotReserverd, event.getTotalSpotReserverd());
        assertEquals(partnerId, event.getPartnerId().getValue());
    }

    @Test
    public void deve_criar_um_evento_valido() {
        var command = new CreateEventCommand("Event A", null, LocalDate.now(), UUID.randomUUID());
        Event event = Event.create(command);
        assertNotNull(event);
        assertEquals(command.getName(), event.getName().getValue());
        assertEquals(command.getDescription(), event.getDescription());
        assertEquals(command.getDate(), event.getDate().getValue());
        assertEquals(command.getPartnerId(), event.getPartnerId().getValue());
    }

    @Test
    public void deve_comparar_se_um_evento_e_igual_ao_outro() {
        var eventA = Event.create(new CreateEventCommand("Event A", null, LocalDate.now(), UUID.randomUUID()));
        var eventB = Event.create(new CreateEventCommand("Event B", null, LocalDate.now(), UUID.randomUUID()));
        var eventC = new Event(
                eventA.getId().getValue(),
                "Event B",
                null,
                LocalDate.now(),
                false,
                0,
                0,
                UUID.randomUUID()
        );
        assertNotEquals(eventA, eventB);
        assertEquals(eventA, eventC);
    }
}
