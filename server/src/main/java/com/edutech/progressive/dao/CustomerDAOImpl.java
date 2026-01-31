package com.edutech.progressive.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dto.CustomerAccountInfo;
import com.edutech.progressive.entity.Customers;

public class CustomerDAOImpl implements CustomerDAO{

    List<Customers> customerList = new ArrayList<>();
    @Override
    public int addCustomer(Customers customers) throws SQLException{
        customerList.add(customers);
        int size = customerList.size();
        return size;
    }

    @Override
    public Customers getCustomerById(int customerId)throws SQLException {
        Customers customer = null;
        for(Customers c : customerList){
            if(c.getCustomerId()==customerId){
                customer = c;
            }
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException{
        
        for(Customers c : customerList){
            if(c.getCustomerId()==customers.getCustomerId()){
                c.setName(customers.getName());
                c.setEmail(customers.getEmail());
                c.setUsername(customers.getUsername());
                c.setPassword(customers.getPassword());
                c.setRole(customers.getRole());
                customerList.add(c);
            }
        }

    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException{
        for(Customers c : customerList){
            if(c.getCustomerId()==customerId){
                customerList.remove(c);
            }
        }
    }

    @Override
    public List<Customers> getAllCustomers() {
        
        return customerList;
    }

    @Override
    public CustomerAccountInfo getCustomerAccountInfo(int customerId){
        
        Customers customer = null;
        for(Customers c : customerList){
            if(c.getCustomerId()==customerId){
                customer = c;
            }
        }
        return customer;
    }

}
