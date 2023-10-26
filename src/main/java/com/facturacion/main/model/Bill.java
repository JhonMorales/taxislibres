package com.facturacion.main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    private Long id;
    private Double totalAmount;
    private String desc;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}
