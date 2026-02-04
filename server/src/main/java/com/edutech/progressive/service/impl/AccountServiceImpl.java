package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.dao.AccountDAO;
import com.edutech.progressive.dao.AccountDAOImpl;
import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.service.AccountService;

public class AccountServiceImpl implements AccountService{

    private AccountDAO accountDAO;
    private static List<Accounts> accountsList = new ArrayList<>();
    
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AccountServiceImpl(AccountDAOImpl accountDAO){
        this.accountDAO = accountDAO;
    }


    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        
        return accountDAO.getAllAccounts();
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {

        return accountDAO.addAccount(accounts);
    }


    ////////did not understand????  /////done
    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
            List<Accounts> sortList = new ArrayList<>(accountDAO.getAllAccounts());
            //accountsList = accountDAO.getAllAccounts();
            Collections.sort(accountsList);
            return sortList;
    }


    ////////did not understand???? Incomplete
    public List<Accounts> getAccountsByUser(int userId) throws SQLException{
            // accountsList = accountDAO.getAllAccounts();
            // for(Accounts a : accountsList){
            //     if(a.g)
            // }

            //return accountDAO.getAllAccountsByCustomers(userId);
            return accountsList;
    }

    public Accounts getAccountById(int accountId) throws SQLException{
        
        return accountDAO.getAccountById(accountId);
       // return accountDAO.getAccountById(accountId);
    }

    public void updateAccount(Accounts accounts)throws SQLException{
        accountDAO.updateAccount(accounts);
    }

    public void deleteAccount(int accountId) throws SQLException{
        accountDAO.deleteAccount(accountId);
    }
}