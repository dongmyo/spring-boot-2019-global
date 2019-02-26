package com.nhnent.edu.spring_boot.assembler;

import com.nhnent.edu.spring_boot.dto.ItemDto;
import com.nhnent.edu.spring_boot.entity.Item;

public class ItemAssembler {
    public ItemDto toDto(Item item) {
        return new ItemDto(item.getItemId(), item.getItemName(), item.getPrice());
    }

}
