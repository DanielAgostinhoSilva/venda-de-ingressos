package br.com.ingresso.domain.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerTest {

    @Test
    public void deve_criar_um_customer() {
        var customer = Customer.create("738.100.590-56", "Jonh Dohn");
        assertNotNull(customer);
    }

    @Test
    public void deve_fazer_uma_copia_dos_dados_informados() {
        String id = "db7d51d1-0559-4281-85a6-e6683180f699";
        String cpf = "73810059056";
        String name = "Jonh Dohn";

        var customer = new Customer(id, cpf, name);

        assertNotNull(customer);
        assertEquals(id, customer.getId());
        assertEquals(cpf, customer.getCpf().getValue());
        assertEquals(name, customer.getName().getValue());
    }
}
