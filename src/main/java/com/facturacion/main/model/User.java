package com.facturacion.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private List<Bill> bills;
}
