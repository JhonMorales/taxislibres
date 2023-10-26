package com.facturacion.main.repository;

import com.facturacion.main.dto.BillSaveDto;
import com.facturacion.main.model.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BillRepository extends CrudRepository<Bill, Long> {
    Bill findByIdBill(Long id);
    Set<Bill> findByUserIdUser(Long id);

    void deleteByIdBill(Long id);
}
