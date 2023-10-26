package com.facturacion.main.mappers;

import com.facturacion.main.dto.BillSaveDto;
import com.facturacion.main.model.Bill;
import com.facturacion.main.model.User;

public class BillSaveMapper {
    public static Bill mapToBill(BillSaveDto billSaveDto){
        return Bill.builder()
                .description(billSaveDto.getDescription())
                .totalAmount(billSaveDto.getTotalAmount())
                .user(
                        User.builder()
                                .idUser(
                                        billSaveDto.getIdUser()
                                ).build()
                )
                .build();
    }
}
