package com.facturacion.main.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bills")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idBill;
    @Column(name = "total_amount", precision = 10)
    private Double totalAmount;
    @Column(name = "desc", length = 255)
    private String desc;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}
