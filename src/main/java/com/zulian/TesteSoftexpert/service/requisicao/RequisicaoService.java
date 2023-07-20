package com.zulian.TesteSoftexpert.service.requisicao;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequisicaoService {

    public void requisicao(String url,HttpEntity requestEntity){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.postForEntity(url,requestEntity.toString(), String.class);
    }
}
