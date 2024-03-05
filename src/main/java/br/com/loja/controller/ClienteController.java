package br.com.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.dto.CalculoDto;
import br.com.loja.dto.ClienteDto;
import br.com.loja.dto.ProdutoDto;
import br.com.loja.model.Cliente;
import br.com.loja.model.Produto;
import br.com.loja.service.LojaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;


@RestController
@RequestMapping("loja")
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private LojaService lojaService;
	
	@PostMapping("cliente")
	@Operation(summary = "Rota responsável pelo cadastro de clientes") 
    @ApiResponse(responseCode = "201",description = "cliente cadastrado com sucesso",content = {
    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDto>cadastrar(@RequestBody @Valid ClienteDto cliente){
		var cadastro = lojaService.cadastrar(cliente);
		return new ResponseEntity<ClienteDto>(cadastro,HttpStatus.CREATED);
	}
	@PostMapping("produtos/{clienteid}")
	@Operation(summary = "Rota responsável por vincular um produto ao cliente e cadastrar no banco de dados")  
	 @ApiResponse(responseCode = "201",description = "produto vinculado ao cliente e cadastrado com sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<ProdutoDto>cadastrarClienteProduto(@RequestBody Produto produto,@PathVariable("clienteid")Long clienteid){
		var cadastroclientePedido = lojaService.cadastrarprodutoCliente(produto, clienteid);
		return new ResponseEntity<ProdutoDto>(cadastroclientePedido,HttpStatus.CREATED);
	}
	@GetMapping("buscaid/{id}")
	@Operation(summary = "Rota responsável por buscar um cliente pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<ClienteDto>buscarId(@PathVariable Long id) {
		var busque = lojaService.buscarId(id);
		return new ResponseEntity<ClienteDto>(busque,HttpStatus.OK);
	}
	@PostMapping("produto")
	@Operation(summary = "Rota responsável pelo cadastro de produtos") 
	 @ApiResponse(responseCode = "201",description = "produto cadastrado com sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<ProdutoDto>cadastrarProduto(@RequestBody @Valid ProdutoDto prod){
		var cadastrarProduto = lojaService.cadastrarProduto(prod);
		return new ResponseEntity<ProdutoDto>(cadastrarProduto,HttpStatus.CREATED);
	}
	@PostMapping("calculo")
	@Operation(summary = "Rota responsável pelo cálculo entre o quantidade e valor do produto")
	 @ApiResponse(responseCode = "201",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<CalculoDto>calcularTotal(@RequestBody CalculoDto calculo){
	var calcular = 	lojaService.calcularTotal(calculo);
	return new ResponseEntity<CalculoDto>(calcular,HttpStatus.OK);
	}
	@GetMapping("bProdutos")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	@Operation(summary = "Rota responsável pa busca de todos os produtos")   
	public ResponseEntity<List<ProdutoDto>>buscarProdutos(){
		var busca =lojaService.buscarProdutos();
		return new ResponseEntity<List<ProdutoDto>>(busca,HttpStatus.OK);
	}
	@GetMapping("produto/{id}")
	@Operation(summary = "Rota responsável por buscar produto pelo id")   
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<ProdutoDto>buscarProdutoId(@PathVariable Long id){
		var buscaId = lojaService.buscarProdutoId(id);
		return new ResponseEntity<ProdutoDto>(buscaId,HttpStatus.OK);
	}
	@DeleteMapping("deletar/{id}")
	@Operation(summary = "Rota responsável por deletar produto pelo id")
	 @ApiResponse(responseCode = "204",description = "produto deletado com sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		 lojaService.excluir(id);
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	@GetMapping("nome")
	@Operation(summary = "Rota responsável por buscar produto pelo nome ou parte do nome") 
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<List<ProdutoDto>>buscarPorNome(@RequestParam(name = "name")String name){
		List<ProdutoDto>buscar = lojaService.buscaPorNome(name);
		return new ResponseEntity<List<ProdutoDto>>(buscar,HttpStatus.OK);
	}
}
