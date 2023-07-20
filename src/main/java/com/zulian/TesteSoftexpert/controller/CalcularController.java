package com.zulian.TesteSoftexpert.controller;


import com.zulian.TesteSoftexpert.model.dto.DividirDto;
import com.zulian.TesteSoftexpert.model.entity.ItemPagamento;
import com.zulian.TesteSoftexpert.model.vo.DividirVo;
import com.zulian.TesteSoftexpert.service.CalcularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calcular")
public class CalcularController {
    @Autowired
    private CalcularService service;

    @PostMapping()
    public DividirVo calcular(@RequestBody DividirDto dto){
      return service.calcular(dto);
    }
}
