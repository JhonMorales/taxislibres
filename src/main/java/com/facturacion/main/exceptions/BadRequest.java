package com.facturacion.main.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BadRequest {
    private int code;
    private String error;
}
