package com.facturacion.main.dto;

import com.facturacion.main.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillSaveDto {
    private Long idBill;
    @NotNull
    private Double totalAmount;
    private String description;
    @NotNull
    private Long idUser;
}
