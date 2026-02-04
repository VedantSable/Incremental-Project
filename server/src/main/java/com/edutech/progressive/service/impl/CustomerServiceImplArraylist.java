package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.service.CustomerService;


public class CustomerServiceImplArraylist implements CustomerService{

    private static List<Customers> customersList;

    public CustomerServiceImplArraylist(){
        this.customersList = new ArrayList<>();
    }
    
    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customersList;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // List<Customers> sortedList = new ArrayList<>(customersList);
        // Collections.sort(sortedList);
        customersList.add(customers); 
        return customersList.size();
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        List<Customers> custList = new ArrayList<>(customersList);
        Collections.sort(custList);
        return custList;
    }
    
    public void emptyArrayList(){
        customersList.clear();
    }

}