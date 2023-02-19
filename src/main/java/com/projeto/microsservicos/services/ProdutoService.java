package com.projeto.microsservicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.microsservicos.model.Produto;
import com.projeto.microsservicos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * Metodo para retornar uma lista de produtos.
	 * 
	 * @return Lista de produtos.
	 */
	public List<Produto> obterTodos() {
		return produtoRepository.findAll();
	}

	/**
	 * Metodo que retorna o produto encontrado pelo seu Id.
	 * 
	 * @param id do produto que será localizado.
	 * @return Retorna o produto caso seja encontrado.
	 */
	public Optional<Produto> obterPorId(Integer id) {
		return produtoRepository.findById(id);
	}

	/**
	 * Metodo para adicionar produto na lista.
	 * 
	 * @param produto que será adicionado.
	 * @return Retorna o produto que foi adicionado na lista.
	 */
	public Produto adicionar(Produto produto) {
		return produtoRepository.save(produto);
	}

	/**
	 * Metodo para deletar o produto por Id.
	 * 
	 * @param do produto a ser deletado.
	 */
	public void deletar(Integer id) {
		produtoRepository.deleteById(id);
	}

	/**
	 * Metodo para atualizar o produto na lista.
	 * 
	 * @param id do produto.
	 * @param produto que será atualizado.
	 * @return Retorna o produto após atualizar a lista.
	 */
	public Produto atualizar(Integer id, Produto produto) {
		produto.setId(id);
		return produtoRepository.save(produto);
	}

}
