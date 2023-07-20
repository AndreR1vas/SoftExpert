package com.zulian.TesteSoftexpert.model.dto;

import com.zulian.TesteSoftexpert.model.entity.FormaPagamento;
import com.zulian.TesteSoftexpert.model.entity.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DividirDto {
    private List<Item> items;
    private FormaPagamento formaPagamento;
    private Boolean taxaGarcon;
    private Double entrega;
}
