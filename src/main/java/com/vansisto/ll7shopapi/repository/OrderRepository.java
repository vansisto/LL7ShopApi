package com.vansisto.ll7shopapi.repository;

import com.vansisto.ll7shopapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
