package com.facturacion.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long idUser;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "age")
    @NotNull
    @Positive
    private Integer age;
    @Column(name = "email")
    @Email
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<Bill> bills;
}
