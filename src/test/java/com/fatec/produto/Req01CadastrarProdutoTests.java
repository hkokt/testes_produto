package com.fatec.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.ProdutoRepository;

@SpringBootTest
class Req01CadastrarProdutotests { //
	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	void ct01_cadastrar_produto_com_sucesso() {
		// Dado que não existem produtos cadastrados
		produtoRepository.deleteAll();

		// quando o usuario cadastra um produto
		Produto produto = new Produto();
		produto.setDescricao("Eletrobomoba 110 v");
		produto.setCategoria("maquina de lavar");
		produto.setCusto(56.66);
		produto.setQuantidadeNoEstoque(10);
		Produto p = produtoRepository.save(produto);

		// então o produto fica disponível para consulta
		assertEquals(1, produtoRepository.count());
		assertNotNull(p);
	}

	@Test
	void ct02_cadastrar_produto_com_descricao_invalida() {
		// dado que o usuario deseja cadastrar um produto
		try {
			// quando a descricao e invalida 
			Produto produto = new Produto();
			produto.setDescricao("");
		} catch (IllegalArgumentException e) {
			assertEquals("A descricao nao deve estar em branco", e.getMessage());
		}
	}
	
	@Test
	void ct02_cadastrar_produto_com_descricao_invalida_nula() {
		// dado que o usuario deseja cadastrar um produto
		try {
			// quando a descricao e invalida 
			Produto produto = new Produto();
			produto.setDescricao(null);
		} catch (IllegalArgumentException e) {
			assertEquals("A descricao nao deve estar em branco", e.getMessage());
		}
	}
}
