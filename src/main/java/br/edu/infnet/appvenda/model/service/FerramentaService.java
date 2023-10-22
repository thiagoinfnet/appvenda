package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Ferramenta;

@Service
public class FerramentaService {

	private Map<Integer, Ferramenta> mapaFerramenta = new HashMap<Integer, Ferramenta>();
	
	public void incluir(Ferramenta ferramenta) {
		mapaFerramenta.put(ferramenta.getCodigo(), ferramenta);
	}
	
	public Collection<Ferramenta> obterLista() {
		return mapaFerramenta.values();
	}
}
