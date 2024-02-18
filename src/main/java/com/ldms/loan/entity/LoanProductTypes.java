package com.ldms.loan.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoanProductTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CsvBindByName(column = "Loan Product Id")
    private Long loanProductId;
    @CsvBindByName(column = "Loan Product Name")
    private String loanProductName;
    @CsvBindByName(column = "Variable Interest Rate")
    private String variableInterestRate;

}
