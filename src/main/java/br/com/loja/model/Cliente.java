package br.com.loja.model;

import java.io.Serializable;
import java.util.List;

import br.com.loja.dto.ClienteDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {
    
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone; 	
	@OneToMany
	@JoinColumn(name= "ID_CLIENTE")
	private List<Produto>produtos;
	
	public Cliente(ClienteDto cliente) {
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}

	
	
}
