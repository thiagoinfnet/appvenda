package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Lanterna;

@Service
public class LanternaService {

	private Map<Integer, Lanterna> mapaLanterna = new HashMap<Integer, Lanterna>();
	
	public void incluir(Lanterna lanterna) {
		mapaLanterna.put(lanterna.getCodigo(), lanterna);
	}
	
	public Collection<Lanterna> obterLista() {
		return mapaLanterna.values();
	}
}
