package com.zulian.TesteSoftexpert.service.PicPay;

import com.zulian.TesteSoftexpert.model.entity.picPay.PicPayEntity;
import com.zulian.TesteSoftexpert.service.requisicao.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class PicPayService {
    @Value("${enderecos.mercadoPago.url}")
    private String url;

//    @Autowired
//    private RequisicaoService requisicaoService;

    public void cobranca(Double valor){
      String token="sua chave";
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("x-picpay-token", token);
      PicPayEntity picPay = new PicPayEntity();

      HttpEntity<PicPayEntity> requestEntity = new HttpEntity(picPay, headers);
      //requisicaoService.requisicao(url, requestEntity);
    }
}
