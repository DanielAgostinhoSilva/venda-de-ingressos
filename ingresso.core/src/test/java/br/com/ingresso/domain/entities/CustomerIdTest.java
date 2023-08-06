package br.com.ingresso.domain.entities;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class CustomerIdTest {

    @Test
    public void deve_criar_um_customerId() {
        UUID id = UUID.fromString("db7d51d1-0559-4281-85a6-e6683180f699");
        var customerId = new CustomerId(id);
        assertNotNull(customerId);
        assertEquals(id, customerId.getValue());
    }

    @Test
    public void deve_criar_um_customerId_com_seu_valor_gerado_automaticamente() {
        CustomerId customerId = new CustomerId(null);
        assertNotNull(customerId);
    }

}
