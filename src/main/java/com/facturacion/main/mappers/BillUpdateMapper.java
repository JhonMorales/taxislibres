package com.facturacion.main.mappers;

import com.facturacion.main.dto.BillUpdateDto;
import com.facturacion.main.model.Bill;
import com.facturacion.main.model.User;

public class BillUpdateMapper {

    public static Bill mapToBill(BillUpdateDto billUpdateDto, Long idBill){
        return Bill.builder()
                .idBill(idBill)
                .description(billUpdateDto.getDescription())
                .totalAmount(billUpdateDto.getTotalAmount())
                .user(
                        User.builder()
                                .idUser(
                                        billUpdateDto.getIdUser()
                                ).build()
                )
                .build();
    }
}
