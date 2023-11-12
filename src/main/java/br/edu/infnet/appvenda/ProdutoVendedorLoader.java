package br.edu.infnet.appvenda;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;


@Order(5)
@Component
public class ProdutoVendedorLoader implements ApplicationRunner {
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	@Transactional
	public void run(ApplicationArguments args) {
		var listaVendedores = vendedorService.obterLista();
		listaVendedores.forEach(vendedor -> {
			System.out.println("VENDEDOR: " + vendedor.toString());
			Collection<Produto> listaProdutos = produtoService.obterLista(vendedor);
			if (listaProdutos != null) {
				System.out.println("*************************************");
				listaProdutos.forEach(produto -> System.out.println("PRODUTO: " + produto.toString()));
			}
			System.out.println("*************************************");
		});
	}

}
