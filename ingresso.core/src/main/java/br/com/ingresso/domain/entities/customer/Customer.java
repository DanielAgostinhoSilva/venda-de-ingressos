package br.com.ingresso.domain.entities.customer;

import br.com.ingresso.common.domain.AggregateRoot;
import br.com.ingresso.common.domain.value.object.Cpf;
import br.com.ingresso.common.domain.value.object.Name;

import java.util.UUID;

public class Customer extends AggregateRoot {
    private CustomerId id;
    private Cpf cpf;
    private Name name;

    public Customer(UUID id, String cpf, String name) {
        this.id = new CustomerId(id);
        this.cpf = Cpf.create(cpf);
        this.name = Name.create(name);
    }

    public static Customer create(String cpf, String name) {
        return new Customer(UUID.randomUUID(), cpf, name);
    }

    public CustomerId getId() {
        return id;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
