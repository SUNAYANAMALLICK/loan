package com.ldms.loan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

import static com.ldms.loan.constant.LoanConstants.ACCOUNT_BALANCE_FORMAT;
import static com.ldms.loan.constant.LoanConstants.PAYMENT_DATE_IS_MANDATORY;

@Entity
@Table(name = "Loan")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long loanId;
    @NotNull
    private Integer customerId;
    @NotNull
    private Long loanProductId;
    @NotNull
    @Digits(integer = 10, fraction = 2, message = ACCOUNT_BALANCE_FORMAT)
    private Long openingBalance;
    @NotNull
    @Digits(integer = 10, fraction = 2, message = ACCOUNT_BALANCE_FORMAT)
    private Long currentBalance;
    @NotNull
    @Digits(integer = 10, fraction = 2, message = ACCOUNT_BALANCE_FORMAT)
    private Long paymentAmount;
    @NotNull(message = PAYMENT_DATE_IS_MANDATORY)
    private LocalDateTime paymentDate;
    @NotNull
    @Digits(integer = 10, fraction = 2, message = ACCOUNT_BALANCE_FORMAT)
    private Long rate;// Number 10,2 Y Interest rate on loan


}
