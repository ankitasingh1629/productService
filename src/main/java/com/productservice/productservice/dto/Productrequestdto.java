package com.productservice.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Productrequestdto {
    private String title;
    private int price;
    private String description;
    private String image;
    private String category;
}
