package com.edutech.progressive.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Accounts;

public class AccountDAOImpl implements AccountDAO {

    private List<Accounts> accountsList = new ArrayList<>();

    @Override
    public int addAccount(Accounts accounts)throws SQLException{
        accountsList.add(accounts);
        int size = accountsList.size();
        return size;
    }

    @Override
    public Accounts getAccountById(int accountId){
        Accounts account = null;
        for(Accounts s : accountsList){
            if(s.getAccountId()==accountId){
                account = s;
            }
        }
        return account;
    }

    @Override
    public void updateAccount(Accounts accounts)throws SQLException {
        for(Accounts s : accountsList){
            if(s.getAccountId()==accounts.getAccountId()){
                // s.setCustomerId(accounts.getCustomerId());
                // s.setBalance(accounts.getBalance());
                accountsList.add(accounts);
            }
        }
    }

    @Override
    public void deleteAccount(int accountId)throws SQLException{
        accountsList.remove(accountId);
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException{

        return accountsList;

    }

    public List<Accounts> getAllAccountsByCustomers(int customer_id) throws SQLException{
        Collections.sort(accountsList);
        return accountsList;
    }

    
}
