package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.service.AccountService;

public class AccountServiceImplArraylist implements AccountService{

    private static List<Accounts> accountsList;

    public AccountServiceImplArraylist(List<Accounts> accountsList){
        accountsList = new ArrayList<>(); 
    }
    

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        //List<Accounts> accounts = new ArrayList<>();
        return accountsList;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        accountsList.add(accounts);
        
        return accountsList.size();
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
       // List<Accounts> sortedList = new ArrayList<>(accountsList);
        Collections.sort(accountsList);
        return accountsList;
    }

    public void emptyArrayList(){
        accountsList.clear();
    }

}