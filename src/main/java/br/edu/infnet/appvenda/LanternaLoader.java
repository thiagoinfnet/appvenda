package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Lanterna;
import br.edu.infnet.appvenda.model.service.LanternaService;

@Order(3)
@Component
public class LanternaLoader implements ApplicationRunner {

	@Autowired
	private LanternaService lanternaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/lanterna.txt");		
		BufferedReader reader = new BufferedReader(file);
		
		String line = reader.readLine();

		String[] fields = null;
		
		while(line != null) {
			
			fields = line.split(";");
			
			Lanterna lanterna = new Lanterna();

			lanterna.setCodigo(Integer.valueOf(fields[0]));
			lanterna.setDescricao(fields[1]);
			lanterna.setEstoque(Boolean.valueOf(fields[2]));
			lanterna.setPreco(Float.valueOf(fields[3]));
			lanterna.setLed(fields[4]);
			lanterna.setBateria(Integer.valueOf(fields[5]));
			
			lanternaService.incluir(lanterna);
			
			line = reader.readLine();
		}
		
		for(Lanterna lanterna: lanternaService.obterLista()) {
			System.out.println("[Lanterna] " + lanterna);			
		}

		reader.close();
	}
}
