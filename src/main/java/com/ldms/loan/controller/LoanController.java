package com.ldms.loan.controller;

import com.ldms.loan.entity.Loan;
import com.ldms.loan.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ldms.loan.constant.LoanConstants.LOAN_CREATED;
import static com.ldms.loan.constant.LoanConstants.ROOT_PATH;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(ROOT_PATH)
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping
    public ResponseEntity<String> createLoan(@RequestBody @Valid final Loan loan){
        loanService.create(loan);
        return new ResponseEntity<>(LOAN_CREATED, CREATED);
    }

}
