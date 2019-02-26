package com.nhnent.edu.spring_boot.service.impl;

import com.nhnent.edu.spring_boot.assembler.ItemAssembler;
import com.nhnent.edu.spring_boot.dto.ItemDto;
import com.nhnent.edu.spring_boot.entity.Item;
import com.nhnent.edu.spring_boot.repository.ItemRepository;
import com.nhnent.edu.spring_boot.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;


    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public List<ItemDto> getItems(Pageable pageable) {
        Page<Item> itemPage = itemRepository.findAll(pageable);

        return itemPage.getContent()
                       .stream()
                       .map(item -> new ItemAssembler().toDto(item))
                       .collect(Collectors.toList());
    }

}
