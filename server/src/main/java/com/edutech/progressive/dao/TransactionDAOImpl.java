package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

//import org.h2.mvstore.tx.Transaction;

import com.edutech.progressive.entity.Transactions;

public class TransactionDAOImpl implements TransactionDAO{

    @Override
    public int addTransaction(Transactions transaction) {
        return -1;
    }

    @Override
    public Transactions getTransactionById(int transactionId) {
        return null;
    }

    @Override
    public void updateTransaction(Transactions transaction) {
        
    }

    @Override
    public void deleteTransaction(int transactionId) {
    
    }

    @Override
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactions = new ArrayList<>();
        return transactions;
    }

    
}
