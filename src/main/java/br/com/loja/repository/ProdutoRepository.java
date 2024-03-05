package br.com.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.loja.dto.ProdutoDto;
import br.com.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto , Long> {
	@Query(value = "select p from Produto p where upper(trim(p.nome)) like %?1% ") 
	List<ProdutoDto> findByName(String name);

}
