package br.com.ingresso.domain.entities.event;

import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.*;

public class EventSpotTest {

    @Test
    public void deve_permitir_copia_os_atributos_de_um_event_spot() {
        UUID eventSpotId = UUID.randomUUID();
        String location = "Location A";
        boolean reserved = false;
        boolean published = false;

        var eventSpot = new EventSpot(
                eventSpotId,
                location,
                reserved,
                published
        );

        assertNotNull(eventSpot);
        assertEquals(eventSpotId, eventSpot.getId().getValue());
        assertEquals(location, eventSpot.getLocation());
        assertEquals(reserved, eventSpot.isReserverd());
        assertEquals(published, eventSpot.isPublished());
    }

    @Test
    public void deve_criar_um_event_spot_valido() {
        var eventSpot = EventSpot.create();
        assertNotNull(eventSpot);
        assertNotNull(eventSpot.getId());
        assertEquals("", eventSpot.getLocation());
        assertFalse(eventSpot.isPublished());
        assertFalse(eventSpot.isPublished());
    }

    @Test
    public void deve_comparar_se_um_event_spot_e_igual_ao_outro() {
        var eventA = EventSpot.create();
        var eventB = EventSpot.create();
        var eventC = new EventSpot(
                eventA.getId().getValue(),
                "Location C",
                false,
               false
        );
        assertNotEquals(eventA, eventB);
        assertEquals(eventA, eventC);
    }
}
