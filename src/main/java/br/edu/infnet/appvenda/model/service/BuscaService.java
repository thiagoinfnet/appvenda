package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service
public class BuscaService {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
    public Collection<Vendedor> buscarPorTermoVendedor(String termo) {
        return vendedorRepository.buscarPorTermo(termo.toLowerCase());
    }

    public Collection<Produto> buscarPorTermoProduto(String termo) {
        return produtoRepository.buscarPorTermo(termo.toLowerCase());
    }
}
