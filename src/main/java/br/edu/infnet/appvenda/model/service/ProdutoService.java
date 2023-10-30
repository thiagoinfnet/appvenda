package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public Produto incluir(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Collection<Produto> obterLista(){	
		return (Collection<Produto>) produtoRepository.findAll();
	}
}