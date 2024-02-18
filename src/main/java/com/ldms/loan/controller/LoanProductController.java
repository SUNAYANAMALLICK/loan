package com.ldms.loan.controller;

import com.ldms.loan.service.LoanProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.ldms.loan.constant.LoanConstants.ROOT_PATH;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(ROOT_PATH)
public class LoanProductController {
    @Autowired
    LoanProductService loanProductService;

    @PostMapping(value = "/product/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> upload(@RequestParam("file") @Valid final MultipartFile loanProductTypes) throws IOException {
        loanProductService.upload(loanProductTypes);
        return new ResponseEntity<>("Uploaded Successfully", CREATED);
    }


}
