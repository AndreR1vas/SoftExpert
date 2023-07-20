package com.zulian.TesteSoftexpert.model.entity.mercadoPago;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemMercadoPago {
    private String id;
    private String title;
    private String description;
    private Integer quantity;
    private Double unit_price;
}
