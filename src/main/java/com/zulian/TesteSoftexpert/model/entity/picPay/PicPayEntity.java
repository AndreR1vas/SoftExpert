package com.zulian.TesteSoftexpert.model.entity.picPay;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PicPayEntity {

    private String referenceId;
    private Double value;
    private LocalDateTime expiresAt;
    private BuyerEntity buyer;
}
