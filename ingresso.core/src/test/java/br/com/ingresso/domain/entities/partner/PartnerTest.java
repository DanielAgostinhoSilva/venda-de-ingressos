package br.com.ingresso.domain.entities.partner;

import br.com.ingresso.common.domain.exception.InvalidNameException;
import br.com.ingresso.common.domain.value.object.Name;
import br.com.ingresso.domain.entities.event.Event;
import br.com.ingresso.domain.entities.event.InitEventCommand;
import br.com.ingresso.domain.entities.partner.Partner;
import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.*;

public class PartnerTest {

    @Test
    public void deve_criar_um_partner() {
        var customer = Partner.create("Partner A");
        assertNotNull(customer);
    }

    @Test
    public void deve_criar_um_evento_apartir_de_um_partner() {
        Partner partner = Partner.create("Partner A");
        InitEventCommand command = new InitEventCommand("Partner event a", null, LocalDate.now());
        Event event = partner.initiEvent(command);
        assertNotNull(event);
        assertEquals(partner.getId(), event.getPartnerId());
        assertEquals(command.getName(), event.getName().getValue());
        assertEquals(command.getDescription(), event.getDescription());
        assertEquals(command.getDate(), event.getDate().getValue());
    }

    @Test
    public void deve_permitir_mudar_nome_do_parceiro() {
        Partner partner = Partner.create("Partner A");
        partner.changeName("Partner B");
        assertEquals("Partner B", partner.getName().getValue());
    }

    @Test
    public void deve_lancar_uma_erro_quando_tentar_mudar_para_um_nome_invalid() {
        Partner partner = Partner.create("Partner A");
        var invalidName = assertThrows(InvalidNameException.class, () -> partner.changeName("aa"));
        var requiredName = assertThrows(InvalidNameException.class, () -> partner.changeName(null));
        assertNotNull(invalidName);
        assertEquals(Name.INVALID_NAME, invalidName.getMessage());
        assertNotNull(requiredName);
        assertEquals(Name.NAME_IS_REQUIRED, requiredName.getMessage());
    }

    @Test
    public void deve_comparar_se_um_partner_e_igual_a_o_outro() {
        var partnerA = Partner.create("Partner A");
        var partnerB = new Partner(partnerA.getId().getValue(), "Partner B");
        var partnerC =  Partner.create( "Partner C");
        assertEquals(partnerA, partnerB);
        assertNotEquals(partnerA, partnerC);
    }

    @Test
    public void deve_fazer_uma_copia_dos_dados_informados() {
        UUID id = UUID.fromString("db7d51d1-0559-4281-85a6-e6683180f699");
        String name = "Partner A";

        var partner = new Partner(id, name);

        assertNotNull(partner);
        assertEquals(id, partner.getId().getValue());
        assertEquals(name, partner.getName().getValue());
    }
}
