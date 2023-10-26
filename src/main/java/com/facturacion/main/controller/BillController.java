package com.facturacion.main.controller;

import com.facturacion.main.model.Bill;
import com.facturacion.main.service.bill.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/bill")
@Validated
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("{id}")
    public ResponseEntity<Bill> getById(@PathVariable("id") Long id){
        Bill findBill = billService.getByIdBill(id);
        if (findBill == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(findBill);
    }
}
