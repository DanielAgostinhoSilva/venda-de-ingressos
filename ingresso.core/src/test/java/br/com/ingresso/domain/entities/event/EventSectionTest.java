package br.com.ingresso.domain.entities.event;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

public class EventSectionTest {

    @Test
    public void deve_permitir_copia_os_atributos_de_um_event_section() {
        UUID eventId = UUID.randomUUID();
        String name = "Event A";
        String description = null;
        boolean published = false;
        Integer totalSpot = 0;
        Integer totalSpotReserverd = 0;
        BigDecimal price = new BigDecimal(0);
        Set<EventSpot> spots = new HashSet<>();

        EventSection eventSection = new EventSection(
                eventId,
                name,
                description,
                published,
                totalSpot,
                totalSpotReserverd,
                price,
                spots
        );

        assertNotNull(eventSection);
        assertEquals(eventId, eventSection.getId().getValue());
        assertEquals(name, eventSection.getName().getValue());
        assertEquals(description, eventSection.getDescription());
        assertEquals(published, eventSection.isPublished());
        assertEquals(totalSpot, eventSection.getTotalSpot());
        assertEquals(totalSpotReserverd, eventSection.getTotalSpotReserverd());
        assertEquals(price, eventSection.getPrice());
        assertEquals(spots, eventSection.getSpots());
    }

    @Test
    public void deve_criar_um_event_section_valido() {
        var command = new CreateEventSectionCommand("Event A", "Test A", 10, new BigDecimal(10.00));
        var event = EventSection.create(command);
        assertNotNull(event);
        assertEquals(command.getName(), event.getName().getValue());
        assertEquals(command.getDescription(), event.getDescription());
        assertEquals(command.getTotalSpot(), event.getTotalSpot());
        assertEquals(command.getPrice(), event.getPrice());
    }

    @Test
    public void deve_comparar_se_um_event_section_e_igual_ao_outro() {
        var eventA =  EventSection.create(new CreateEventSectionCommand("Event A", "Test A", 10, new BigDecimal(10.00)));
        var eventB =  EventSection.create(new CreateEventSectionCommand("Event B", "Test B", 10, new BigDecimal(10.00)));
        var eventC = new EventSection(
                eventA.getId().getValue(),
                "Event B",
                null,
                false,
                0,
                0,
               new BigDecimal(10.00),
                new HashSet<>()
        );
        assertNotEquals(eventA, eventB);
        assertEquals(eventA, eventC);
    }
}
