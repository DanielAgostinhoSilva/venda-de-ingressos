package br.com.ingresso.domain.entities.partner;

import br.com.ingresso.domain.entities.partner.PartnerId;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PartnerIdTest {

    @Test
    public void deve_criar_um_PartnerId() {
        UUID id = UUID.fromString("db7d51d1-0559-4281-85a6-e6683180f699");
        var customerId = new PartnerId(id);
        assertNotNull(customerId);
        assertEquals(id, customerId.getValue());
    }

    @Test
    public void deve_criar_um_partnerId_com_seu_valor_gerado_automaticamente() {
        var customerId = new PartnerId(null);
        assertNotNull(customerId);
    }

}
