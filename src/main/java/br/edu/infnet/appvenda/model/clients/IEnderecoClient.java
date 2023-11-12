package br.edu.infnet.appvenda.model.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.appvenda.model.domain.Endereco;

@Service
@FeignClient(value = "jplaceholder", url = "https://viacep.com.br/")
public interface IEnderecoClient {
	@RequestMapping(method = RequestMethod.GET, value = "/ws/{cep}/json/", produces = "application/json")
	Endereco buscarEndereco(@PathVariable("cep") String cep);
}