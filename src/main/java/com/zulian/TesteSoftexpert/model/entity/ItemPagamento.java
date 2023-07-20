package com.zulian.TesteSoftexpert.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPagamento {
    private Double valor;
    private String nome;
    private Long porcentagem;

    public ItemPagamento(Double valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }


}
