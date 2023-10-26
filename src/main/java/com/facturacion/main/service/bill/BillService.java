package com.facturacion.main.service.bill;

import com.facturacion.main.model.Bill;

import java.util.Set;

public interface BillService {
    Bill getByIdBill(Long id);
    Set<Bill> getByIdUser(Long id);
}
