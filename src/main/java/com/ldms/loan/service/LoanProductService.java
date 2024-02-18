package com.ldms.loan.service;

import com.ldms.loan.entity.LoanProductTypes;
import com.ldms.loan.repository.LoanProductRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

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

    public void upload(final MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<LoanProductTypes> csvToBean = new CsvToBeanBuilder<LoanProductTypes>(reader)
                    .withType(LoanProductTypes.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            csvToBean.parse().forEach(loanProductType -> create(loanProductType));

        }


    }
}
