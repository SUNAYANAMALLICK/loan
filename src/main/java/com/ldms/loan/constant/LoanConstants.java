package com.ldms.loan.constant;

public class LoanConstants {

    /****  Request Mapping   ****/
    public static final String ROOT_PATH = "/api/v1/loan";

    /****  Validation Error Message   ****/

    public static final String ID_LENGTH = "ID must have least 3 digits : ";
    public static final String INVALID_LOAN_PRODUCT = "Invalid Loan Product";
    public static final String ACCOUNT_BALANCE_FORMAT = "Account balance must have at most 10 digits, with 2 after the decimal point";
    public static final String PAYMENT_DATE_IS_MANDATORY = "payment Date is mandatory";

    /****  Success Message   ****/
    public static final String LOAN_CREATED = "Loan Created.";

}
