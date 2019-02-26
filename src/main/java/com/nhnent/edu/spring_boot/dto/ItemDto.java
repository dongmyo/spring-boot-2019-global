package com.nhnent.edu.spring_boot.dto;

public class ItemDto {
    private final Long id;
    private final String name;
    private final Long price;


    public ItemDto(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

}
