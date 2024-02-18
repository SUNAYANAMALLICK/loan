package com.ldms.loan.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoanComponent {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoanComponent(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private void executeTrigger() {
        // Execute the stored procedure to execute the trigger
        jdbcTemplate.execute("CALL execute_loan_insert_trigger()");
    }
}
