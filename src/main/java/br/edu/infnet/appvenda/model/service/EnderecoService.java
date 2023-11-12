package br.edu.infnet.appvenda.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.clients.IEnderecoClient;
import br.edu.infnet.appvenda.model.domain.Endereco;

@Service
public class EnderecoService {
	@Autowired
	private IEnderecoClient iEnderecoClient;
	
	public Endereco buscarEndereco(String cep) {
		return iEnderecoClient.buscarEndereco(cep);
	}
}