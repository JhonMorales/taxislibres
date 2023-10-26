package com.facturacion.main.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillUpdateDto {
    private Long idBill;
    @NotNull
    private Double totalAmount;
    private String description;
    @NotNull
    private Long idUser;
}
