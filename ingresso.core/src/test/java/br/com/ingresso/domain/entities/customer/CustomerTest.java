package br.com.ingresso.domain.entities.customer;

import br.com.ingresso.domain.entities.customer.Customer;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void deve_criar_um_customer() {
        var customer = Customer.create("738.100.590-56", "Jonh Dohn");
        assertNotNull(customer);
    }

    @Test
    public void deve_comparar_se_um_customer_e_igual_a_o_outro() {
        var customerA = Customer.create("738.100.590-56", "Jonh Dohn");
        var customerB = new Customer(customerA.getId().getValue(), "845.018.820-26", "Jonh Dohn2");
        var customerC = Customer.create("738.100.590-56", "Jonh Dohn");
        assertEquals(customerA, customerB);
        assertNotEquals(customerA, customerC);
    }

    @Test
    public void deve_fazer_uma_copia_dos_dados_informados() {
        UUID id = UUID.fromString("db7d51d1-0559-4281-85a6-e6683180f699");
        String cpf = "73810059056";
        String name = "Jonh Dohn";

        var customer = new Customer(id, cpf, name);

        assertNotNull(customer);
        assertEquals(id, customer.getId().getValue());
        assertEquals(cpf, customer.getCpf().getValue());
        assertEquals(name, customer.getName().getValue());
    }
}
