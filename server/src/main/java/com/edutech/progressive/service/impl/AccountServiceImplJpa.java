package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.dao.AccountDAOImpl;
import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.repository.AccountRepository;
import com.edutech.progressive.service.AccountService;

@Service
public class AccountServiceImplJpa implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceImplJpa(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    
    public List<Accounts> getAllAccounts() throws SQLException {
        return accountRepository.findAll();
    }

    public List<Accounts> getAccountsByUser(int userId) throws SQLException{
        return accountRepository.findAccountsByCustomerId(userId);
    }

    public Accounts getAccountsById(int accountId) throws SQLException{
        return accountRepository.findById(accountId).get();
    }


    
    public int addAccount(Accounts accounts) throws SQLException {
        accountRepository.save(accounts);
        return accounts.getAccountId();
    }

    public void updateAccount(Accounts accounts) throws SQLException{
        //accountRepository.save(accounts);
        if(accounts == null || !accountRepository.existsById(accounts.getAccountId())){
            return;
        }

        accountRepository.save(accounts);
    }

    public void deleteAccount(int accountId){
        //accountRepository.deleteById(accountId);
        accountRepository.deleteById(accountId);
    }

    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        
        List<Accounts> list = accountRepository.findAll();

        Collections.sort(list);

        // list.sort(Comparator.comparingDouble(Accounts::getBalance));
        // return list;
        // return accountRepository.findAllByOrderByBalanceAsc();
        return list;
    }
    
    
}