package br.com.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.dto.CalculoDto;
import br.com.loja.dto.ClienteDto;
import br.com.loja.dto.ProdutoDto;
import br.com.loja.model.Cliente;
import br.com.loja.model.Produto;
import br.com.loja.repository.ClienteRepository;
import br.com.loja.repository.ProdutoRepository;

@Service
public class LojaService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public ClienteDto cadastrar(ClienteDto cliente) {
		var cadastre = new Cliente(cliente);
		var cadastrando = clienteRepository.save(cadastre);
		return new ClienteDto(cadastrando);
	}
	
	public ProdutoDto cadastrarProduto(ProdutoDto produto) {
	var cadProduto  = new Produto(produto);
	var cadastrado  = produtoRepository.save(cadProduto);
	return new ProdutoDto(cadastrado);
	}
	
	public ProdutoDto cadastrarprodutoCliente(Produto produto,Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		produto.setClientes(cliente);
		var salvar = produtoRepository.save(produto);
		return new ProdutoDto(salvar);
	}
	public ClienteDto buscarId(Long id) {
		var busca = clienteRepository.findById(id).get();
		return new ClienteDto(busca);
	}
	 public CalculoDto calcularTotal( CalculoDto calculo) {
	        var produto = new Produto();
	        produto.setQuantidade(calculo.getQuantidade());
	        produto.setPreco(calculo.getPreco());
	     
	        double total = produto.getQuantidade() * produto.getPreco();	       
	        
	        produto.setTotal(total);	
	        
	        produtoRepository.save(produto);
	       
	        return new CalculoDto(produto);
		
	 }
	 public List<ProdutoDto>buscarProdutos(){
		 var busca = produtoRepository.findAll().stream().map(ProdutoDto::new).toList();
		 return busca;
	 }
	 public ProdutoDto buscarProdutoId(Long id) {
		 var buscarId = produtoRepository.findById(id).get();
		 return new ProdutoDto(buscarId);
	 }
	 public void excluir(Long id) {
	  produtoRepository.deleteById(id);
		 
	 }
	 public List<ProdutoDto>buscaPorNome(String name){
		 var busca = produtoRepository.findByName(name.trim().toUpperCase());
			 
		 return busca;
	 }
}
