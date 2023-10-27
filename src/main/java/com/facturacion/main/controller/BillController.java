package com.facturacion.main.controller;

import com.facturacion.main.dto.BillSaveDto;
import com.facturacion.main.dto.BillUpdateDto;
import com.facturacion.main.exceptions.BadRequest;
import com.facturacion.main.mappers.BillSaveMapper;
import com.facturacion.main.mappers.BillUpdateMapper;
import com.facturacion.main.model.Bill;
import com.facturacion.main.model.User;
import com.facturacion.main.service.bill.BillService;
import com.facturacion.main.service.user.UserService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Slf4j
@RequestMapping("api/bill")
@Validated
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<Bill> getById(@PathVariable("id") Long id){
        Bill findBill = billService.getByIdBill(id);
        if (findBill == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(findBill);
    }

    @PostMapping
    public ResponseEntity<User> createBill(@Valid @RequestBody BillSaveDto billDto, BindingResult bindingResult) {
        User existsUser = userService.getUserById(billDto.getIdUser());
        if (existsUser == null) return ResponseEntity.notFound().build();
        Bill bill = BillSaveMapper.mapToBill(billDto);
        Bill savedBill = billService.saveBill(bill);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBill.getIdBill()).toUri()
        ).build();
    }

    @PutMapping("{idBill}")
    public ResponseEntity<Bill> updateBill(@PathVariable("idBill") Long idBill,
                                           @Valid @RequestBody BillUpdateDto billUpdateDto, BindingResult bindingResult){
        User existsUser = userService.getUserById(billUpdateDto.getIdUser());
        if (existsUser == null) return ResponseEntity.notFound().build();
        Bill existsBill = billService.getByIdBill(idBill);
        if (existsBill == null) return ResponseEntity.notFound().build();
        Bill mapBill = BillUpdateMapper.mapToBill(billUpdateDto, idBill);
        Bill updatedBill = billService.saveBill(mapBill);
        return ResponseEntity.accepted().body(updatedBill);
    }

    @DeleteMapping("{idBill}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBill(@PathVariable("idBill") Long id){
        billService.deleteByIdBill(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<BadRequest> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(400).body(
                BadRequest.builder().error(e.getMessage())
                        .code(400).build()
        );
    }
}
