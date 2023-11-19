package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.Optional;

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
	
	public Lanterna obterPorId(Integer id) {
		Optional<Lanterna> optionalLanterna = lanternaRepository.findById(id);
		return optionalLanterna.orElse(null);
	}

	@Transactional
	public Lanterna atualizar(Integer id, Lanterna novaLanterna) {
		Optional<Lanterna> optionalLanterna = lanternaRepository.findById(id);
		if (optionalLanterna.isPresent()) {
			Lanterna lanterna = optionalLanterna.get();
			lanterna.setDescricao(novaLanterna.getDescricao());
			lanterna.setEstoque(novaLanterna.isEstoque());
			lanterna.setVendedor(novaLanterna.getVendedor());
			lanterna.setPreco(novaLanterna.getPreco());
			return lanternaRepository.save(lanterna);
		}
		return null;
	}
	
	@Transactional
	public void excluir(Integer id) {
		lanternaRepository.deleteByCodigo(id);
	}
	
    public Long contar() {
        return lanternaRepository.count();
    }
}
