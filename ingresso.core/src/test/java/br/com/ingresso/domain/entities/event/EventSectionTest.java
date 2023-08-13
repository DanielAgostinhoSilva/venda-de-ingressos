package br.com.ingresso.domain.entities.event;

import br.com.ingresso.common.domain.exception.InvalidNameException;
import br.com.ingresso.common.domain.value.object.Name;
import br.com.ingresso.domain.exception.InvalidEventSectionException;
import br.com.ingresso.templates.EventSectionTemplate;
import org.junit.Test;

import java.math.BigDecimal;
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
        var eventSection = EventSection.create(command);
        assertNotNull(eventSection);
        assertEquals(command.getName(), eventSection.getName().getValue());
        assertEquals(command.getDescription(), eventSection.getDescription());
        assertEquals(command.getTotalSpot(), eventSection.getTotalSpot());
        assertEquals(command.getPrice(), eventSection.getPrice());
        assertEquals(10, eventSection.getSpots().size());
    }

    @Test
    public void deve_permitir_alterar_o_nome_do_event_section() {
        var eventSection = EventSectionTemplate.valido();
        eventSection.changeName("Event Section name B");
        assertEquals("Event Section name B", eventSection.getName().getValue());
    }

    @Test
    public void deve_lancar_um_erro_quando_tentar_alterar_o_nome_para_um_nome_invalido() {
        var eventSection = EventSectionTemplate.valido();
        var invalidName = assertThrows(InvalidNameException.class, () -> eventSection.changeName("ab"));
        var requiredName = assertThrows(InvalidNameException.class, () -> eventSection.changeName(null));
        assertNotNull(invalidName);
        assertEquals(Name.INVALID_NAME, invalidName.getMessage());
        assertNotNull(requiredName);
        assertEquals(Name.NAME_IS_REQUIRED, requiredName.getMessage());
    }

    @Test
    public void deve_permitir_altera_a_descricao_do_event_section() {
        var eventSection = EventSectionTemplate.valido();
        eventSection.changeDescription("Description altered");
        assertEquals("Description altered", eventSection.getDescription());
    }

    @Test
    public void deve_permitir_alterar_a_descricao_do_event_section_para_null() {
        var eventSection = EventSectionTemplate.valido();
        eventSection.changeDescription(null);
        assertNull(eventSection.getDescription());
    }

    @Test
    public void deve_permitir_alterar_o_preco_do_event_section() {
        var eventSection = EventSectionTemplate.valido();
        var newPrice = new BigDecimal(10.0);
        eventSection.changePrince(newPrice);
        assertEquals(newPrice, eventSection.getPrice());
    }

    @Test
    public void deve_lancar_um_erro_quando_tentar_alterar_o_preco_para_um_valor_negativo_ou_null() {
        var eventSection = EventSectionTemplate.valido();
        var negativePrice = assertThrows(InvalidEventSectionException.class, () -> eventSection.changePrince(new BigDecimal(-10.0)));
        var invalidPrice = assertThrows(InvalidEventSectionException.class, () -> eventSection.changePrince(null));
        assertNotNull(negativePrice);
        assertEquals("Invalid price -10", negativePrice.getMessage());
        assertNotNull(invalidPrice);
        assertEquals("Price can not be null", invalidPrice.getMessage());
    }

    @Test
    public void deve_permitir_publicar_um_event_section() {
        var eventSection = EventSectionTemplate.valido();
        eventSection.publish();
        assertTrue(eventSection.isPublished());
    }

    @Test
    public void deve_permitir_despublicar_um_event_section() {
        var eventSection = EventSectionTemplate.valido();
        eventSection.unPublish();
        assertFalse(eventSection.isPublished());
    }

    @Test
    public void deve_pulicar_um_event_section_com_seus_spots() {
        var eventSection = EventSectionTemplate.validoComSpot();
        eventSection.publishAll();
        assertTrue(eventSection.isPublished());
        eventSection.getSpots().forEach(spot -> assertTrue(spot.isPublished()));
    }

    @Test
    public void deve_comparar_se_um_event_section_e_igual_ao_outro() {
        var eventSectionA =  EventSection.create(new CreateEventSectionCommand("Section A", "Description A", 10, new BigDecimal(10.00)));
        var eventSectionB =  EventSection.create(new CreateEventSectionCommand("Section B", "Description B", 10, new BigDecimal(10.00)));
        var eventSectionC = new EventSection(
                eventSectionA.getId().getValue(),
                "Section C",
                null,
                false,
                0,
                0,
               new BigDecimal(10.00),
                new HashSet<>()
        );
        assertNotEquals(eventSectionA, eventSectionB);
        assertEquals(eventSectionA, eventSectionC);
    }
}
