package com.nhnent.edu.spring_boot.service;

import com.nhnent.edu.spring_boot.dto.ItemDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    List<ItemDto> getItems(Pageable pageable);

}
