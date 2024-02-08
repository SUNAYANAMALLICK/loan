package com.ldms.loan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ldms.loan.entity.Loan;
import com.ldms.loan.entity.LoanProductTypes;
import com.ldms.loan.repository.LoanProductRepository;
import com.ldms.loan.repository.LoanRepository;
import com.ldms.loan.service.LoanProductService;
import com.ldms.loan.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LoanRepository loanRepository;

    @MockBean
    private LoanService loanService;

    @Autowired
    private LoanProductRepository loanProductRepository;

    @Autowired
    private LoanProductService loanProductService;

    private final String path = "/api/v1/loan";


    private LoanProductTypes loanProductTypes;

    private Loan validLoan;

    private Loan invalidLoan;



    @BeforeEach
    void setUp() {
        // Perform setup before each test
        loanProductTypes = loanProductTypes.builder().loanProductId(1L).loanProductName("Fixed Rate Product").variableInterestRate("N").build();
        loanProductRepository.save(loanProductTypes);




    }

    private String asJsonString(final Object obj) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void validInput_ReturnsCreated() throws Exception {

        validLoan =  new Loan().builder().loanId(123456L).loanProductId(loanProductRepository.findAll().get(0).getLoanProductId()).rate((long) 12.23).customerId(1203)
                .currentBalance(12000L).openingBalance(10000L).paymentAmount(5000L).paymentDate(LocalDateTime.of(2024,2,22,13,20)).build();

        mockMvc.perform(MockMvcRequestBuilders.post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(validLoan)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Loan Created."));
        loanRepository.deleteAll();
    }



}
