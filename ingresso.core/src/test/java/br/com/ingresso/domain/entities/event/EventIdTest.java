package br.com.ingresso.domain.entities.event;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EventIdTest {

    @Test
    public void deve_criar_um_EventId() {
        UUID id = UUID.fromString("db7d51d1-0559-4281-85a6-e6683180f699");
        var eventId = new EventId(id);
        assertNotNull(eventId);
        assertEquals(id, eventId.getValue());
    }

    @Test
    public void deve_criar_um_eventId_com_seu_valor_gerado_automaticamente() {
        var eventId = new EventId(null);
        assertNotNull(eventId);
    }

}
