package com.edutech.progressive.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.entity.Transactions;
import com.edutech.progressive.service.CustomerService;
import com.edutech.progressive.service.impl.CustomerServiceImplArraylist;
import com.edutech.progressive.service.impl.CustomerServiceImplJpa;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/customers")
//@Qualifier("customerRepository")
public class CustomerController {

    @Autowired
    CustomerService cs;
    // @Autowired
    // CustomerServiceImplArraylist csa;

    
    // @Autowired
    // CustomerServiceImplJpa csj;

    public CustomerController(CustomerService cs){
        this.cs = cs;
        // this.csa = csa;
    }
    // CustomerServiceImplArraylist csa

    @GetMapping()
    public List<Customers> getAllCustomers() throws SQLException {
        return cs.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customers getCustomerById(int customerId) throws SQLException{
        // return ResponseEntity.ok(cs.getCustomerById(customerId));
        //return ResponseEntity.status(200).body(cs.getCustomerById(customerId));
        return cs.getCustomerById(customerId);
    }

    @GetMapping("/fromArrayList")
    public List<Customers> getAllCustomersFromArrayList()throws SQLException{
        return cs.getAllCustomers();
    }

    @GetMapping("/fromArrayList/all")
    public List<Customers> getAllCustomersSortedByNameFromArrayList()throws SQLException{
        return cs.getAllCustomersSortedByName();
    }
    
    @PostMapping()
    public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) throws SQLException{
        return ResponseEntity.status(201).body(cs.addCustomer(customers));
    }

    @PostMapping("/toArrayList")
    @ResponseStatus(HttpStatus.CREATED)
    public int addCustomersToArrayList(@RequestBody Customers customers)throws SQLException{
        return cs.addCustomer(customers);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable int customerId,@RequestBody Customers customers) throws SQLException{
        cs.updateCustomer(customers);
        return ResponseEntity.status(200).body(null);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(int customerId) throws SQLException{
        cs.deleteCustomer(customerId);
        return ResponseEntity.status(200).body(null);
    }

    public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int customerId) {
        return null;
    }
}
