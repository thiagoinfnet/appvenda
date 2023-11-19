package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Ferramenta;
import br.edu.infnet.appvenda.model.repository.FerramentaRepository;

@Service
public class FerramentaService {

	@Autowired
	private FerramentaRepository ferramentaRepository;

	@Transactional
	public Ferramenta incluir(Ferramenta ferramenta) {
		return ferramentaRepository.save(ferramenta);
	}
	
	public Collection<Ferramenta> obterLista(){	
		return (Collection<Ferramenta>) ferramentaRepository.findAll();
	}
	
	@Transactional
	public void excluir(Integer id) {
		ferramentaRepository.deleteByCodigo(id);
	}
	
    public Long contar() {
        return ferramentaRepository.count();
    }
}
