package com.nhnent.edu.spring_boot.repository;

import com.nhnent.edu.spring_boot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
