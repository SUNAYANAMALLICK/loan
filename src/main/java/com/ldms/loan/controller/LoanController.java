package com.ldms.loan.controller;

import com.ldms.loan.entity.Loan;
import com.ldms.loan.exception.InvalidLoanException;
import com.ldms.loan.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ldms.loan.constant.LoanConstants.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(ROOT_PATH)
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping
    public ResponseEntity<String> createLoan(@RequestBody @Valid final Loan loan) {
        loanService.create(loan);
        return new ResponseEntity<>(LOAN_CREATED, CREATED);
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<List<Loan>> find(@PathVariable final Long customerId){
        List<Loan> loans = loanService.find(customerId) ;
        if(loans.isEmpty()){
            throw new InvalidLoanException(String.format("%s: %s",LOAN_NOT_FOUND, customerId));
        }
        return new ResponseEntity<>(loans , OK);
    }

}
