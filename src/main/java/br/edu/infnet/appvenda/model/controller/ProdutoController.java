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

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
    @GetMapping(value = "/")
    @ResponseBody
    public Collection<Produto> telaLista() {    	
        return produtoService.obterLista();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Produto obterVendedorPorId(@PathVariable Integer id) {
        return produtoService.obterPorId(id);
    }

    @PostMapping("/")
    @ResponseBody
    public Produto criarVendedor(@RequestBody Produto produto) {
        return produtoService.incluir(produto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Produto atualizarVendedor(@PathVariable Integer id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletarVendedor(@PathVariable Integer id) {
    	produtoService.excluir(id);
    }
}
