package com.facturacion.main.repository;

import com.facturacion.main.model.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {
    Bill getByIdBill(Long id);
}
