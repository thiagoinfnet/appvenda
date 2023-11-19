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

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
    @GetMapping(value = "/")
    @ResponseBody
    public Collection<Vendedor> telaLista() {    	
        return vendedorService.obterLista();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Vendedor obterVendedorPorId(@PathVariable Integer id) {
        return vendedorService.obterPorId(id);
    }

    @PostMapping("/")
    @ResponseBody
    public Vendedor criarVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.incluir(vendedor);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Vendedor atualizarVendedor(@PathVariable Integer id, @RequestBody Vendedor vendedor) {
        return vendedorService.atualizar(id, vendedor);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletarVendedor(@PathVariable Integer id) {
        vendedorService.excluir(id);
    }
    
    @GetMapping("/count")
    @ResponseBody
    public Long contarVendedores() {
        return vendedorService.contar();
    }
}
