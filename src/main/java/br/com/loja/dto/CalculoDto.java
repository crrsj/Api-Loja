package br.com.loja.dto;

import br.com.loja.model.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalculoDto { 
 
private Integer quantidade;
 private Double preco;
 private Double total;
 public CalculoDto(Produto produto) {
	this.quantidade = produto.getQuantidade();
	this.preco = produto.getPreco();
	this.total = produto.getTotal();
	}

 
}
