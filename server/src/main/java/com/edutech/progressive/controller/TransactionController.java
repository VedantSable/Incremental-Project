package com.edutech.progressive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edutech.progressive.entity.Transactions;
import com.edutech.progressive.service.TransactionService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {


    @Autowired
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping()
    public ResponseEntity<List<Transactions>> getAllTransactions() throws SQLException{
        return ResponseEntity.status(200).body(transactionService.getAllTransactions());
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable int transactionId) throws SQLException{
        return ResponseEntity.status(200).body(transactionService.getTransactionById(transactionId));
    }

    @PostMapping()
    public ResponseEntity<Integer> addTransaction(@RequestBody Transactions transaction) throws SQLException{
        return ResponseEntity.status(201).body(transactionService.addTransaction(transaction));
    }

    @PutMapping("/{transactionId}")
    public ResponseEntity<Void> updateTransaction(@PathVariable int transactionId,@RequestBody Transactions transaction) throws SQLException{
        transactionService.updateTransaction(transaction);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int transactionId)throws SQLException {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{customerId}")
    public List<Transactions> getAllTransactionsByCustomerId(@PathVariable int customerId){
        return getAllTransactionsByCustomerId(customerId);
    }
}
