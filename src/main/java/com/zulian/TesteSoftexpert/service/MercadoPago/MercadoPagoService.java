package com.zulian.TesteSoftexpert.service.MercadoPago;

import com.zulian.TesteSoftexpert.model.entity.ItemPagamento;
import com.zulian.TesteSoftexpert.model.entity.mercadoPago.ItemMercadoPago;
import com.zulian.TesteSoftexpert.model.entity.mercadoPago.MercadoPagoEntity;
import com.zulian.TesteSoftexpert.model.entity.mercadoPago.Payer;
import com.zulian.TesteSoftexpert.service.requisicao.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoService {
    @Value("${enderecos.mercadoPago.url}")
    private String url;

//    @Autowired
//    private RequisicaoService requisicaoService;

    public void cobranca(Double valor){
       String token="";

       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
       headers.set("Authorization", "Bearer "+token);

       MercadoPagoEntity mercadoPago = new MercadoPagoEntity();
       mercadoPago.setDescription("decricao");
       Payer payer = new Payer();
       mercadoPago.setPayer(payer);
       mercadoPago.setToken("");
       mercadoPago.setInstallments(1);
       mercadoPago.setTransaction_amount(valor);
       ItemMercadoPago item = new ItemMercadoPago();
        List<ItemMercadoPago> items= new ArrayList<>();
       mercadoPago.setItems(items);
       mercadoPago.setExternal_reference("MP0001");
       HttpEntity<MercadoPagoEntity> requestEntity = new HttpEntity(mercadoPago, headers);

       //requisicaoService.requisicao(url,requestEntity);
    }
}
