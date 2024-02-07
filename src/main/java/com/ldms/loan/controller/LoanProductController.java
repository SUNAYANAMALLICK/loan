package com.ldms.loan.controller;

import com.ldms.loan.entity.Loan;
import com.ldms.loan.entity.LoanProductTypes;
import com.ldms.loan.service.LoanProductService;
import com.ldms.loan.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/ldm/loan/product")
public class LoanProductController {
    @Autowired
    LoanProductService loanProductService;

    @PostMapping(value = "/new")
    public ResponseEntity<Long> createNew(@RequestBody @Valid final LoanProductTypes loanProductTypes){
        return new ResponseEntity<>(loanProductService.create(loanProductTypes), CREATED);
    }


}
