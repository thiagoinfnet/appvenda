package br.edu.infnet.appvenda.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.infnet.appvenda.model.domain.Lanterna;
import br.edu.infnet.appvenda.model.service.LanternaService;

@Controller
@RequestMapping("/lanterna")
public class LanternaController {

	@Autowired
	private LanternaService lanternaService;
	
	@GetMapping(value = "/")
	@ResponseBody
	public Collection<Lanterna> lista() {
		return lanternaService.obterLista();
	}
	
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletarLanterna(@PathVariable Integer id) {
    	lanternaService.excluir(id);
    }
}
