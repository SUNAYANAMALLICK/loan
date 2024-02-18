package com.ldms.loan.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


@SpringBootTest
@AutoConfigureMockMvc
public class LoanProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUploadLoanProductTypes() throws Exception {
        // Given
        InputStream inputStream = getClass().getResourceAsStream("/test_loan_product_types.csv");
        MultipartFile multipartFile = new MockMultipartFile("file", "test_loan_product_types.csv", "text/csv", inputStream);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/v1/loan/product/upload")
                        .file((MockMultipartFile) multipartFile))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Uploaded Successfully"));
    }
}
