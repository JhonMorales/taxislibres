package com.facturacion.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "bills")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idBill;
    @Column(name = "total_amount", precision = 10)
    @NotNull
    private Double totalAmount;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "idUser")
    @JsonIgnore
    private User user;

}
