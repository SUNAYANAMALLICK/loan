package com.ldms.loan.repository;

import com.ldms.loan.entity.LoanProductTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanProductRepository extends JpaRepository<LoanProductTypes, Long> {
    public Optional<Boolean> findByLoanProductId(final Long loanProductId);

}
