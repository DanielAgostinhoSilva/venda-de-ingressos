package br.com.ingresso.domain.entities.event;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EventSectionIdTest {

    @Test
    public void deve_criar_um_EventSectionId() {
        UUID id = UUID.fromString("db7d51d1-0559-4281-85a6-e6683180f699");
        var eventSectionId = new EventSectionId(id);
        assertNotNull(eventSectionId);
        assertEquals(id, eventSectionId.getValue());
    }

    @Test
    public void deve_criar_um_eventSectionId_com_seu_valor_gerado_automaticamente() {
        var eventSectionId = new EventSectionId(null);
        assertNotNull(eventSectionId);
    }

}
