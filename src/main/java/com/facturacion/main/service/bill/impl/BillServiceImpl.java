package com.facturacion.main.service.bill.impl;

import com.facturacion.main.model.Bill;
import com.facturacion.main.repository.BillRepository;
import com.facturacion.main.service.bill.BillService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class BillServiceImpl implements BillService {
    private BillRepository billRepository;
    @Override
    public Bill getByIdBill(Long id) {
        return billRepository.getByIdBill(id);
    }
}
