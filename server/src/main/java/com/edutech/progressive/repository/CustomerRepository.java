package com.edutech.progressive.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Customers;
@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer>{

    Customers findByCustomerId(int customerId);

    void deleteByCustomerId(int customerId);

    public List<Customers> findAllByOrderByNameAsc() throws SQLException;

    //Optional<Customers> findById(int customerId);

}
