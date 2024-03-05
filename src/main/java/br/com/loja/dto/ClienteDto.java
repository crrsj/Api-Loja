package br.com.loja.dto;

import br.com.loja.model.Cliente;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDto {	
	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	
	public ClienteDto(Cliente cadastrando) {
	this.nome = cadastrando.getNome();
	this.telefone = cadastrando.getTelefone();
	}

	
	
}
