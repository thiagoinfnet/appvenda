package br.edu.infnet.appvenda.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.infnet.appvenda.model.domain.Ferramenta;
import br.edu.infnet.appvenda.model.service.FerramentaService;

@Controller
@RequestMapping("/ferramenta")
public class FerramentaController {

	@Autowired
	private FerramentaService ferramentaService;
	
	@GetMapping(value = "/")
	@ResponseBody
	public Collection<Ferramenta> lista() {
		return ferramentaService.obterLista();
	}
	
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletarLanterna(@PathVariable Integer id) {
    	ferramentaService.excluir(id);
    }
    
    @GetMapping("/count")
    @ResponseBody
    public Long contar() {
        return ferramentaService.contar();
    }
}
