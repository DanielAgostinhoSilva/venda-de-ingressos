package br.com.ingresso.domain.entities.event;

import br.com.ingresso.templates.EventTemplate;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
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
        Set<EventSection> sections = new HashSet<>();

        Event event = new Event(
                eventId,
                name,
                description,
                eventDate,
                published,
                totalSpot,
                totalSpotReserverd,
                partnerId,
                sections
        );

        assertNotNull(event);
        assertEquals(eventId, event.getId().getValue());
        assertEquals(name, event.getName().getValue());
        assertEquals(description, event.getDescription());
        assertEquals(eventDate, event.getDate().getValue());
        assertEquals(published, event.isPublished());
        assertEquals(totalSpot, event.getTotalSpots());
        assertEquals(totalSpotReserverd, event.getTotalSpotReserverd());
        assertEquals(partnerId, event.getPartnerId().getValue());
        assertEquals(sections, event.getSections());
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
                UUID.randomUUID(),
                new HashSet<>()
        );
        assertNotEquals(eventA, eventB);
        assertEquals(eventA, eventC);
    }

    @Test
    public void deve_incrementar_total_spot_quando_um_event_section_for_adicionado() {
        var event = EventTemplate.valido();
        var command = new AddSectionCommand("Section Test A", "Description Test a", 100, new BigDecimal(10.00));
        event.addSection(command);
        assertEquals(1, event.getSections().size());
        assertEquals(Integer.valueOf(100), event.getTotalSpots());
    }
}
