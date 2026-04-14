package com.example.zenVault.service;

import com.example.zenVault.dto.TransactionDepositeRequest;
import com.example.zenVault.dto.TransctionDepositeResponse;
import com.example.zenVault.entity.AccountEntity;
import com.example.zenVault.entity.TransactionEntity;
import com.example.zenVault.exception.UserNotFound;
import com.example.zenVault.repository.AccountRepository;
import com.example.zenVault.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired AccountRepository accountRepository;
    @Autowired TransactionRepository transactionRepository;

    public TransctionDepositeResponse deposite(TransactionDepositeRequest request){
        //extract userID from jwt token
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // here we found userId and account in acount table if both are match and acc take from request
       AccountEntity existsUser =  accountRepository.findByAccountNumberAndUserEntityId(request.getAccountNumber(), userId);

       if(existsUser==null){
           throw new UserNotFound("Account or user not found in record");
       }

       //create new object for transction add
        TransactionEntity trans = new TransactionEntity();

       // fetch amount from request
        double beforeTrans =  existsUser.getBalance();
        beforeTrans = beforeTrans + request.getAmount();

        existsUser.setBalance(beforeTrans);
       //fetch balance from database

       //update balance after make trnsction
        trans.setAmount(request.getAmount());
       trans.setBalance(beforeTrans);

       trans.setCreateAt(LocalDateTime.now());
       trans.setTransctionType("Deposite");
       trans.setAccountNumber(request.getAccountNumber());
      TransactionEntity transactionSaved =  transactionRepository.save(trans);

       // here we set response for user

         TransctionDepositeResponse transRespo = new TransctionDepositeResponse();
         transRespo.setMessage("Successfull Credite");
         transRespo.setAmount(request.getAmount());
         transRespo.setBalance(beforeTrans);
         return transRespo;
    }
}
