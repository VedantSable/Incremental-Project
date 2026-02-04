package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Transactions;
import com.edutech.progressive.repository.AccountRepository;
import com.edutech.progressive.repository.TransactionRepository;

@Service
public class TransactionServiceImplJpa {

    @Autowired
    private TransactionRepository transactionRepository;

    

    public TransactionServiceImplJpa(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transactions> getAllTransactions() throws SQLException{
        return transactionRepository.findAll();
    }

    public Transactions getTransactionById(int transactionId) throws SQLException{
        return transactionRepository.findById(transactionId).get();
    }

    public int addTransaction(Transactions transactions) throws SQLException{
        transactionRepository.save(transactions);
        return transactions.getTransactionId();
    }

    public void updateTransaction(Transactions transaction) throws SQLException{
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(int transactionId) throws SQLException{
        transactionRepository.deleteById(transactionId);
    }

    public List<Transactions> getTransactionByCustomerId(int customerId)throws SQLException{
        return transactionRepository.findByAccountIdOrderByTransactionDateDesc(customerId);
    }
}
