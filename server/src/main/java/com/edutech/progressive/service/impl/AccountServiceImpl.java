package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.AccountDAO;
import com.edutech.progressive.dao.AccountDAOImpl;
import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.service.AccountService;

public class AccountServiceImpl implements AccountService{

    private AccountDAO accountDAO;
    
    public AccountServiceImpl(AccountDAOImpl accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        List<Accounts> accounts = new ArrayList<>();
        return accounts;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        return -1;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        List<Accounts> accounts = new ArrayList<>();
        return accounts;
    }

    public List<Accounts> getAccountsByUser(int userId) throws SQLException{
        List<Accounts> accounts = new ArrayList<>();
        return accounts;
    }

    public Accounts getAccountById(int accountId) throws SQLException{
        return null;
    }

    public void updateAccount(Accounts accounts)throws SQLException{

    }

    public void deleteAccount(int accountId) throws SQLException{

    }
}