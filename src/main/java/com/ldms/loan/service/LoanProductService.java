package com.ldms.loan.service;

import com.ldms.loan.entity.LoanProductTypes;
import com.ldms.loan.repository.LoanProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanProductService {

    @Autowired
    LoanProductRepository loanProductRepository;
    public Long create(final LoanProductTypes loanProductTypes) {
        return loanProductRepository.save(loanProductTypes).getLoanProductId();
    }

    public boolean findByLoanProduct(final Long loanProductId){
        return loanProductRepository.findByLoanProductId(loanProductId).isPresent();
    }
}
