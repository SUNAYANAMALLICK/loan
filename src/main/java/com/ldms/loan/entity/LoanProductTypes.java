package com.ldms.loan.entity;

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
    private Long loanProductId;
    private String loanProductName;
    private String variableInterestRate;

}
