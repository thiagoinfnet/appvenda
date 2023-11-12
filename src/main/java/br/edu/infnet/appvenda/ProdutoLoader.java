package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Ferramenta;
import br.edu.infnet.appvenda.model.domain.Lanterna;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(4)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produto.txt");		
		BufferedReader reader = new BufferedReader(file);
		
		String line = reader.readLine();
		
		String[] fields = null;

		while(line != null) {
			System.out.println(line);
			fields = line.split(";");
			Vendedor vendedor = vendedorService.obterPorId(1);
			try{
				switch (fields[6]) {
				case "L":
					Lanterna lanterna = new Lanterna();
					lanterna.setCodigo(Integer.valueOf(fields[0]));
					lanterna.setDescricao(fields[1]);
					lanterna.setEstoque(Boolean.valueOf(fields[2]));
					lanterna.setPreco(Float.valueOf(fields[3]));
					lanterna.setLed(fields[4]);
					lanterna.setBateria(Integer.valueOf(fields[5]));
					lanterna.setVendedor(vendedor);
					
					produtoService.incluir(lanterna);
					
					break;
	
				case "F":
					Ferramenta ferramenta = new Ferramenta();
					ferramenta.setCodigo(Integer.valueOf(fields[0]));
					ferramenta.setDescricao(fields[1]);
					ferramenta.setEstoque(Boolean.valueOf(fields[2]));
					ferramenta.setPreco(Float.valueOf(fields[3]));
					ferramenta.setTipo(fields[4]);
					ferramenta.setDimensoes(fields[5]);
					ferramenta.setVendedor(vendedor);
					
					produtoService.incluir(ferramenta);
					
					
					break;
	
				default:
					break;
				}
			} catch (DataIntegrityViolationException exception) {
				System.err.println(exception);
			} catch (ConstraintViolationException exception) {
				System.err.println(exception);
			}
			
									
			line = reader.readLine();
		}

		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
		reader.close();
	}
}