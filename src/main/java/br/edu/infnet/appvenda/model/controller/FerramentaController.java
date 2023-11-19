package br.edu.infnet.appvenda.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
    @GetMapping("/{id}")
    @ResponseBody
    public Ferramenta obterVendedorPorId(@PathVariable Integer id) {
        return ferramentaService.obterPorId(id);
    }
    
    @PostMapping("/")
    @ResponseBody
    public Ferramenta criarFerramenta(@RequestBody Ferramenta ferramenta) {
        return ferramentaService.incluir(ferramenta);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Ferramenta atualizarFerramenta(@PathVariable Integer id, @RequestBody Ferramenta ferramenta) {
        return ferramentaService.atualizar(id, ferramenta);
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
