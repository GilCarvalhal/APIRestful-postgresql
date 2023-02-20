package com.projeto.microsservicos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.microsservicos.model.Produto;
import com.projeto.microsservicos.model.exception.ResourceNotFoundException;
import com.projeto.microsservicos.repository.ProdutoRepository;
import com.projeto.microsservicos.shared.ProdutoDTO;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * Metodo para retornar uma lista de produtos.
	 * 
	 * @return Lista de produtos.
	 */
	public List<ProdutoDTO> obterTodos() {
		// Retorna uma lista de produtos model
		List<Produto> produtos = produtoRepository.findAll();

		return produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
				.collect(Collectors.toList());
	}

	/**
	 * Metodo que retorna o produto encontrado pelo seu Id.
	 * 
	 * @param id do produto que será localizado.
	 * @return Retorna o produto caso seja encontrado.
	 */
	public Optional<ProdutoDTO> obterPorId(Integer id) {
		// Obtendo optional de produto pelo id
		Optional<Produto> produto = produtoRepository.findById(id);
		// Se não encontrar, lança exception
		if (produto.isEmpty()) {
			throw new ResourceNotFoundException("Produto com id: " + id + " Não encontrado.");
		}
		// Convertendo meu optional de produto em um produtoDto
		ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
		// Criando e retornando um optional de produtoDto
		return Optional.of(dto);
	}

	/**
	 * Metodo para adicionar produto na lista.
	 * 
	 * @param produto que será adicionado.
	 * @return Retorna o produto que foi adicionado na lista.
	 */
	public ProdutoDTO adicionar(ProdutoDTO produto) {
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
	 * @param id      do produto.
	 * @param produto que será atualizado.
	 * @return Retorna o produto após atualizar a lista.
	 */
	public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {
		produto.setId(id);
		return produtoRepository.save(produto);
	}

}
