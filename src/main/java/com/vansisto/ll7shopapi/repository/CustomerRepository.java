package com.vansisto.ll7shopapi.repository;

import com.vansisto.ll7shopapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
