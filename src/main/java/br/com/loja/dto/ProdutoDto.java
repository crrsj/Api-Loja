package br.com.loja.dto;

import br.com.loja.model.Cliente;
import br.com.loja.model.Produto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDto {
	
	@NotBlank
	private String nome;
	private String imagem;	
	private Integer quantidade;
	private Double preco;
	private Double total;
	private Cliente clientes;
	
	public ProdutoDto(Produto cadastrado) {
		this.nome = cadastrado.getNome();
		this.imagem = cadastrado.getImagem();
		this.preco = cadastrado.getPreco();
		this.quantidade = cadastrado.getQuantidade();
		this.total = cadastrado.getTotal();
	}
}
