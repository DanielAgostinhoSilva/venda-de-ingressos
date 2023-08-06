package br.com.ingresso.common.domain.value.object;


import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class IdTest {

    @Test
    public void deve_criar_um_id_valido() {
        UUID uuid = UUID.fromString("0dcd2f69-8402-462d-a2da-62dc10120e52");
        Id id = new Id(uuid);
        assertNotNull(id);
        assertEquals(uuid, id.getValue());
    }


}
