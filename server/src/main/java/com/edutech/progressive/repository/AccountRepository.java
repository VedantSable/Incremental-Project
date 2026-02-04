package com.edutech.progressive.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Accounts;
@Repository
public interface AccountRepository extends JpaRepository<Accounts,Integer>{

    public List<Accounts> findAllByOrderByBalanceAsc() throws SQLException;

    public List<Accounts> findAccountsByCustomerId(int customerId)throws SQLException;
}
