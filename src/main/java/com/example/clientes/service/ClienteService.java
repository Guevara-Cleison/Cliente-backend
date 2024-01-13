package com.example.clientes.service;

import java.util.List;

import com.example.clientes.entity.Cliente;

public interface ClienteService {
	
	List<Cliente> consultarClientes();
	
	Cliente guardarCliente(Cliente cliente);
	
	Cliente actualizarCliente(Cliente cliente);
	
	void eliminarCliente(Long id);

}
