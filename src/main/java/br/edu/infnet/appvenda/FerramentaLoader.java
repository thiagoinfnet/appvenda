package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Ferramenta;
import br.edu.infnet.appvenda.model.service.FerramentaService;

@Order(4)
@Component
public class FerramentaLoader implements ApplicationRunner {

	@Autowired
	private FerramentaService ferramentaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/ferramenta.txt");		
		BufferedReader reader = new BufferedReader(file);
		
		String line = reader.readLine();

		String[] fields = null;
		
		while(line != null) {
			
			fields = line.split(";");
			
			Ferramenta ferramenta = new Ferramenta();

			ferramenta.setCodigo(Integer.valueOf(fields[0]));
			ferramenta.setDescricao(fields[1]);
			ferramenta.setEstoque(Boolean.valueOf(fields[2]));
			ferramenta.setPreco(Float.valueOf(fields[3]));
			ferramenta.setTipo(fields[4]);
			ferramenta.setDimensoes(fields[5]);
			
			ferramentaService.incluir(ferramenta);
			
			line = reader.readLine();
		}
		
		for(Ferramenta ferramenta: ferramentaService.obterLista()) {
			System.out.println("[Ferramenta] " + ferramenta);			
		}

		reader.close();
	}
}
