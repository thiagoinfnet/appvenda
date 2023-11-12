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

import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.EnderecoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/vendedor.txt");
		BufferedReader reader = new BufferedReader(file);
		
		String line = reader.readLine();
		
		String[] fields = null;
		
		while(line != null) {
			
			fields  = line.split(";");
			
			try{
				Vendedor vendedor = new Vendedor();
				
				vendedor.setNome(fields[0]);
				vendedor.setCpf(fields[1]);
				vendedor.setEmail(fields[2]);
				Endereco endereco = enderecoService.buscarEndereco("21098-765");
				vendedor.setEndereco(endereco);
				
				vendedorService.incluir(vendedor);
			} catch (DataIntegrityViolationException exception) {
				System.err.println(exception);
			} catch (ConstraintViolationException exception) {
				System.err.println(exception);
			}
		
			line = reader.readLine();
		}
		
		for(Vendedor vendedor: vendedorService.obterLista()) {
			System.out.println("Vendedor: " + vendedor);
		}
		
		reader.close();
	}
}
