package br.com.loja.model;

import java.io.Serializable;

import br.com.loja.dto.ProdutoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto implements Serializable {
    
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String imagem;
	private Double preco;
	private Integer quantidade;
	private Double total;
	
	
	@ManyToOne
	@JoinColumn(name= "ID_CLIENTE")
	private Cliente clientes;
	
	public Produto(ProdutoDto produto) {
		this.nome = produto.getNome();
		this.imagem = produto.getImagem();
		this.preco = produto.getPreco();
		
	}

}
