package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Lanterna;
import br.edu.infnet.appvenda.model.repository.LanternaRepository;

@Service
public class LanternaService {

	@Autowired
	private LanternaRepository lanternaRepository;

	@Transactional
	public Lanterna incluir(Lanterna lanterna) {
		return lanternaRepository.save(lanterna);
	}
	
	public Collection<Lanterna> obterLista(){	
		return (Collection<Lanterna>) lanternaRepository.findAll();
	}
	
	@Transactional
	public void excluir(Integer id) {
		lanternaRepository.deleteByCodigo(id);
	}
	
    public Long contar() {
        return lanternaRepository.count();
    }
}
