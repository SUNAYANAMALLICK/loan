package com.ldms.loan.service;

import com.ldms.loan.entity.Loan;
import com.ldms.loan.exception.InvalidLoanException;
import com.ldms.loan.repository.LoanProductRepository;
import com.ldms.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ldms.loan.constant.LoanConstants.ID_LENGTH;
import static com.ldms.loan.constant.LoanConstants.INVALID_LOAN_PRODUCT;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanProductService loanProductService;

    private void validate(final Loan loan){
        validateLoanId(loan.getLoanId());
        validateLoanProductId(loan.getLoanProductId());
    }

    private void validateLoanId(Long loanId) {
        if (loanId == null || loanId<=99){
            throw new InvalidLoanException(ID_LENGTH + loanId);
        }
    }
    private void validateLoanProductId(Long loanProductId) {
        if(!loanProductService.findByLoanProduct(loanProductId)){
            throw new InvalidLoanException(INVALID_LOAN_PRODUCT + loanProductId);
        }
        else if (loanProductId == null || loanProductId<=99){
            throw new InvalidLoanException(ID_LENGTH + loanProductId);
        }
    }
    public Long create(Loan loan) {
        validate(loan);
        return loanRepository.save(loan).getLoanId();
    }

    public List<Loan> find(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }
}
