/**
 * 
 */
package br.com.rpires.services;

import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	//private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		//this.clienteDAO = clienteDAO;
	}



	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}



}
