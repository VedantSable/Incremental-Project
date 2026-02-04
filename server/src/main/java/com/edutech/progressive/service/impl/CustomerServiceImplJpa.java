package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.repository.CustomerRepository;
import com.edutech.progressive.service.CustomerService;

@Service
public class CustomerServiceImplJpa implements CustomerService{

   // @Autowired
    //@Qualifier("customerRepository")
    @Autowired
    private final CustomerRepository customerRepository;
    
    public CustomerServiceImplJpa(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customers> getAllCustomers()throws SQLException{
        return customerRepository.findAll();
    }

    public int addCustomer(Customers customers)throws SQLException{
        return customerRepository.save(customers).getCustomerId();
    }

    public List<Customers> getAllCustomersSortedByName() throws SQLException{
        return customerRepository.findAllByOrderByNameAsc();
    }

    public void updateCustomer(Customers customers) throws SQLException{
        Customers c = customerRepository.findById(customers.getCustomerId()).get();
        c.setEmail(customers.getEmail());
        c.setName(customers.getName());
        c.setPassword(customers.getPassword());
        c.setRole(customers.getRole());
        c.setUsername(customers.getUsername());
        customerRepository.save(customers);
    }

    public void deleteCustomers(int customerId) throws SQLException{
        customerRepository.deleteByCustomerId(customerId);
    }

    public Customers getCustomerById(int customerId) throws SQLException{
        return customerRepository.findByCustomerId(customerId);
    }
}