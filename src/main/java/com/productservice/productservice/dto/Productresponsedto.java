package com.productservice.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Productresponsedto {
    private Long id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;
}
