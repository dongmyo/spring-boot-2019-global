package com.nhnent.edu.spring_boot.controller;

import com.nhnent.edu.spring_boot.dto.ItemDto;
import com.nhnent.edu.spring_boot.service.ItemService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemDto> list(Pageable pageable) {
        return itemService.getItems(pageable);
    }

}
