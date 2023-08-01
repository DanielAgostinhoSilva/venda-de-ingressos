package br.com.ingresso.domain.entities;

import java.util.UUID;

public class Customer {
    private String id;
    private String cpf;
    private String name;

    private Customer(String id, String cpf, String name) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
    }

    public static Customer create(String cpf, String name) {
        return new Customer(UUID.randomUUID().toString(), cpf, name);
    }

    public String getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
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
