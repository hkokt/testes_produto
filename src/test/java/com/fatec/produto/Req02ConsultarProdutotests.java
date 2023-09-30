package com.fatec.produto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.ProdutoRepository;

@SpringBootTest
class Req02ConsultarProdutotests {

	@Autowired
	private ProdutoRepository produtoRepository;

	@BeforeEach
	void setup() {
		// Dado que não existem produtos cadastrados
		produtoRepository.deleteAll();
	}

	@Test
	void ct01_consultar_produto_com_sucesso() {

		// quando o usuario cadastra um produto
		Produto produto = new Produto();
		produto.setDescricao("Eletrobomoba 110 v");
		produto.setCategoria("maquina de lavar");
		produto.setCusto(56.66);
		produto.setQuantidadeNoEstoque(10);
		produtoRepository.save(produto);

		// Dado que o produto está cadastrado quando consulto o produto pelo id
		Produto p = produtoRepository.findById(1L).get();

		// então os detalhes do produto são aprensentados
		assertNotNull(p);
	}

}
