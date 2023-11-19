package br.edu.infnet.appvenda.model.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.BuscaService;

@Controller
@RequestMapping("/busca")
public class BuscaController {

    @Autowired
    private BuscaService buscaService;

    @GetMapping("/{termo}")
    @ResponseBody
    public ResponseEntity<?> buscarPorTermo(@PathVariable String termo) {
        Collection<Vendedor> vendedores = buscaService.buscarPorTermoVendedor(termo);
        Collection<Produto> produtos = buscaService.buscarPorTermoProduto(termo);

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("vendedores", vendedores);
        resultado.put("produtos", produtos);

        return ResponseEntity.ok(resultado);
    }
}
