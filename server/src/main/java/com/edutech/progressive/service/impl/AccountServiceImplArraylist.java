package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.service.AccountService;

public class AccountServiceImplArraylist implements AccountService{

    private static List<Accounts> accountsList = new ArrayList<>();

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        //List<Accounts> accounts = new ArrayList<>();
        return accountsList;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        accountsList.add(accounts);
        int size = accountsList.size();
        return size;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        List<Accounts> sortedList = new ArrayList<>(accountsList);
        Collections.sort(sortedList);
        return accountsList;
    }

    public void emptyArrayList(){
        accountsList = new ArrayList<>();
    }

}