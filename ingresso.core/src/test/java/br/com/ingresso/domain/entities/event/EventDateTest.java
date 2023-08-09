package br.com.ingresso.domain.entities.event;

import br.com.ingresso.domain.exception.InvalidEventException;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EventDateTest {

    @Test
    public void deve_criar_um_event_date_valido() {
        LocalDate date = LocalDate.now();
        EventDate eventDate = EventDate.create(date);
        assertNotNull(eventDate);
        assertEquals(date, eventDate.getValue());
    }

    @Test
    public void deve_lancar_um_erro_quando_data_do_evento_for_nulo() {
        var invalidEventException = assertThrows(InvalidEventException.class, () -> EventDate.create(null));
        assertEquals("Event date is required", invalidEventException.getMessage());
    }
}
