package com.example.test.entities;

import org.thymeleaf.standard.expression.Each;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String bic;
    private String address;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "bank_customer",
            joinColumns = {@JoinColumn(name = "bank_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private List<Employee> customers;


    public Bank() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Employee> customers) {
        this.customers = customers;
    }
}

