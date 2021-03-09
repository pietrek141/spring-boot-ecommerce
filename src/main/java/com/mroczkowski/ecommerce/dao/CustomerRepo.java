package com.mroczkowski.ecommerce.dao;

import com.mroczkowski.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail);
}
