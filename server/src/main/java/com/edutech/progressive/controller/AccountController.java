package com.edutech.progressive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.service.impl.AccountServiceImplJpa;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImplJpa accountServiceImplJpa;

    public AccountController(AccountServiceImplJpa accountServiceImplJpa) {
        this.accountServiceImplJpa = accountServiceImplJpa;
    }

    @GetMapping()
    public List<Accounts> getAllAccounts() throws SQLException{
        return accountServiceImplJpa.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    public Accounts getAccountById(@PathVariable int accountId) throws SQLException{
        return accountServiceImplJpa.getAccountById(accountId);
    }

    @GetMapping("/user/{userId}")
    public List<Accounts> getAccountsByUser(@PathVariable int userId) throws NumberFormatException, SQLException {
        return accountServiceImplJpa.getAccountsByUser(userId);
    }

    @PostMapping()
    public ResponseEntity<Integer> addAccount(@RequestBody Accounts accounts)throws SQLException {
        return new ResponseEntity<>(accountServiceImplJpa.addAccount(accounts),HttpStatus.CREATED);
    }

    @PutMapping("/update/{accountId}")
    public ResponseEntity<Void> updateAccount(@PathVariable int accountId,@RequestBody Accounts accounts) throws SQLException {
        accountServiceImplJpa.updateAccount(accounts);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{accountId}")
    public ResponseEntity<Void> deleteAccount(int accountId)throws SQLException {
        accountServiceImplJpa.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}