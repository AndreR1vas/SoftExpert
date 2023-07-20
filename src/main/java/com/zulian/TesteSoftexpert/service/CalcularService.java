package com.zulian.TesteSoftexpert.service;

import com.zulian.TesteSoftexpert.model.dto.DividirDto;
import com.zulian.TesteSoftexpert.model.entity.FormaPagamento;
import com.zulian.TesteSoftexpert.model.entity.Item;
import com.zulian.TesteSoftexpert.model.entity.ItemPagamento;
import com.zulian.TesteSoftexpert.model.vo.DividirVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CalcularService {

    @Autowired
    private PagamentoService pagamento;

    public DividirVo calcular(DividirDto dto){
       List<ItemPagamento> items = separarPorUsuario(dto);
       DividirVo vo = new DividirVo();
       Double valorTotalProdutos = calcularValorTotalProdutos(items);
       for (ItemPagamento item: items){
           item.setPorcentagem(calcularPorcentagemPorPessoa(item.getValor(), valorTotalProdutos));
           item.setValor(calcularValorPorPessoa(dto.getTotalPagar(), item));
           enviarPagamentos(dto.getFormaPagamento(),item.getValor());
       }
       vo.setItems(items);
       return vo;
    }

    public Double calcularValorTotalProdutos(List<ItemPagamento> items) {
      Double valorTotal = 0D;
      for (ItemPagamento item : items){
         valorTotal += item.getValor();
      }
      return valorTotal;
    }

    public Long calcularPorcentagemPorPessoa(Double valor ,Double valorTotalProdutos){
        Double valorPorcentual = ((100* valor)/valorTotalProdutos);
        return valorPorcentual.longValue();
    }

    public Double calcularValorPorPessoa( Double valorTotalProdutos, ItemPagamento item){
        Double valor = 0D;
        valor = (valorTotalProdutos * item.getPorcentagem()) / 100D;
        return valor;
    }

    public List<ItemPagamento> separarPorUsuario(DividirDto dto){
      try {
          List<ItemPagamento> items = new ArrayList<>();
          for (Item item : dto.getItems()) {
              ItemPagamento iten = new ItemPagamento(item.getValor(), item.getNome(), 0L);
              if (items.size() > 0) {
                  for (ItemPagamento iten1 : items) {
                      if (iten1.getNome().equalsIgnoreCase(iten.getNome())) {
                          Double valor = iten1.getValor() + item.getValor();
                          iten1.setValor(valor);
                      } else {
                          items.add(iten);
                          break;
                      }
                  }
              } else {
                  items.add(iten);
              }
          }
          return items;
      }catch (Exception e){
        log.error(e.getMessage());
        return null;
      }
    }

    public void enviarPagamentos(FormaPagamento formaPagamento,Double valor){
        pagamento.enviarPagamento(formaPagamento, valor);
    }
}
