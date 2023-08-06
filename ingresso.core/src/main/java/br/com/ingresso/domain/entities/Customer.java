package br.com.ingresso.domain.entities;

import br.com.ingresso.common.domain.AggregateRoot;
import br.com.ingresso.common.domain.Entity;
import br.com.ingresso.common.domain.value.object.Cpf;
import br.com.ingresso.common.domain.value.object.Name;

import java.util.UUID;

public class Customer extends AggregateRoot {
    private String id;
    private Cpf cpf;
    private Name name;

    public Customer(String id, String cpf, String name) {
        this.id = id;
        this.cpf = Cpf.create(cpf);
        this.name = Name.create(name);
    }

    public static Customer create(String cpf, String name) {
        return new Customer(UUID.randomUUID().toString(), cpf, name);
    }

    public String getId() {
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
