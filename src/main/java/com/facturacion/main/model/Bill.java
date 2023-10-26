package com.facturacion.main.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
