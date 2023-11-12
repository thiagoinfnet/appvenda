package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Lanterna;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.LanternaService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(3)
@Component
public class LanternaLoader implements ApplicationRunner {

	@Autowired
	private LanternaService lanternaService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/lanterna.txt");		
		BufferedReader reader = new BufferedReader(file);
		
		String line = reader.readLine();

		String[] fields = null;
		
		while(line != null) {
			
			fields = line.split(";");
			try{
				Lanterna lanterna = new Lanterna();
				Vendedor vendedor = vendedorService.obterPorId(1);
				lanterna.setCodigo(Integer.valueOf(fields[0]));
				lanterna.setDescricao(fields[1]);
				lanterna.setEstoque(Boolean.valueOf(fields[2]));
				lanterna.setPreco(Float.valueOf(fields[3]));
				lanterna.setLed(fields[4]);
				lanterna.setBateria(Integer.valueOf(fields[5]));
				lanterna.setVendedor(vendedor);
				
				lanternaService.incluir(lanterna);
			} catch (DataIntegrityViolationException exception) {
				System.err.println(exception);
			} catch (ConstraintViolationException exception) {
				System.err.println(exception);
			}
			
			line = reader.readLine();
		}
		
		for(Lanterna lanterna: lanternaService.obterLista()) {
			System.out.println("[Lanterna] " + lanterna);			
		}

		reader.close();
	}
}
