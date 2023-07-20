package com.zulian.TesteSoftexpert.model.entity.mercadoPago;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MercadoPagoEntity {
    private Payer payer;
    private List<ItemMercadoPago> items;
    private String description;
    private String external_reference;
    private Integer installments;
    private String payment_method_id;
    private String token;
    private Double transaction_amount;
}
