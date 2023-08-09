package br.com.ingresso.domain.entities.partner;

import br.com.ingresso.domain.entities.partner.Partner;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class PartnerTest {

    @Test
    public void deve_criar_um_partner() {
        var customer = Partner.create("Partner A");
        assertNotNull(customer);
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
