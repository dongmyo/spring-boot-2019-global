package com.nhnent.edu.spring_boot.repository;

import com.nhnent.edu.spring_boot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
