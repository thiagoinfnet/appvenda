package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public Produto incluir(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Collection<Produto> obterLista() {
		return (Collection<Produto>) produtoRepository.findAll();
	}

	public Produto obterPorId(Integer id) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		return optionalProduto.orElse(null);
	}

	public Collection<Produto> obterLista(Vendedor vendedor){
		return (Collection<Produto>) produtoRepository.obterLista(vendedor.getId());
    }

	@Transactional
	public Produto atualizar(Integer id, Produto novoVendedor) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if (optionalProduto.isPresent()) {
			Produto produto = optionalProduto.get();
			return produtoRepository.save(produto);
		}
		return null;
	}

	@Transactional
	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
}