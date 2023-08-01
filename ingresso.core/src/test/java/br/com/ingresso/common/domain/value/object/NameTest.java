package br.com.ingresso.common.domain.value.object;


import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {

    @Test
    public void deve_criar_um_nome_valido() {
        Name name = new Name("John Don");
        assertNotNull(name);
        assertEquals("John Don", name.getValue());
    }

    @Test
    public void deve_verificar_se_os_nome_sao_iguais() {
        Name name1 = new Name("John Don");
        Name name2 = new Name("John Don");

        assertNotNull(name1);
        assertNotNull(name2);
        assertTrue(name1.equals(name2));
    }
}
