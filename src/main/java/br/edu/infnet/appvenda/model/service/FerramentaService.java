package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.Optional;

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
	
	public Ferramenta obterPorId(Integer id) {
		Optional<Ferramenta> optionalFerramenta= ferramentaRepository.findById(id);
		return optionalFerramenta.orElse(null);
	}
	
	public Collection<Ferramenta> obterLista(){	
		return (Collection<Ferramenta>) ferramentaRepository.findAll();
	}
	
	@Transactional
	public Ferramenta atualizar(Integer id, Ferramenta novaFerramenta) {
		Optional<Ferramenta> optionalFerramenta = ferramentaRepository.findById(id);
		if (optionalFerramenta.isPresent()) {
			Ferramenta ferramenta = optionalFerramenta.get();
			ferramenta.setDescricao(novaFerramenta.getDescricao());
			ferramenta.setEstoque(novaFerramenta.isEstoque());
			ferramenta.setVendedor(novaFerramenta.getVendedor());
			ferramenta.setTipo(novaFerramenta.getTipo());
			ferramenta.setPreco(novaFerramenta.getPreco());
			ferramenta.setDimensoes(novaFerramenta.getDimensoes());
			return ferramentaRepository.save(ferramenta);
		}
		return null;
	}
	
	@Transactional
	public void excluir(Integer id) {
		ferramentaRepository.deleteByCodigo(id);
	}
	
    public Long contar() {
        return ferramentaRepository.count();
    }
}
