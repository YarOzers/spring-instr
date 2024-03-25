package com.example.ddeeemmoo.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {


    // DTO  не принимает поле ID
    String name;
    Short amount;
}
