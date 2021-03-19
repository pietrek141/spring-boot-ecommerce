package com.mroczkowski.ecommerce.dao;

import com.mroczkowski.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("https://angular-ecommerce-frontend.herokuapp.com")
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail);
}
