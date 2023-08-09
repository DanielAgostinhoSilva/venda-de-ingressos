package br.com.ingresso.domain.entities.event;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EventSpotIdTest {

    @Test
    public void deve_criar_um_event_spot_id() {
        UUID id = UUID.fromString("db7d51d1-0559-4281-85a6-e6683180f699");
        var eventId = new EventSpotId(id);
        assertNotNull(eventId);
        assertEquals(id, eventId.getValue());
    }

    @Test
    public void deve_criar_um_event_spot_id_com_seu_valor_gerado_automaticamente() {
        var eventId = new EventSpotId(null);
        assertNotNull(eventId);
    }

}
