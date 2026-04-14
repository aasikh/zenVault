package com.example.zenVault.controller;

import com.example.zenVault.dto.TransactionDepositeRequest;
import com.example.zenVault.dto.TransctionDepositeResponse;
import com.example.zenVault.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
 @Autowired  TransactionService transactionService;


    @PostMapping("/deposite")
    public TransctionDepositeResponse deposite(@RequestBody TransactionDepositeRequest request){
     return transactionService.deposite(request);
    }
}
