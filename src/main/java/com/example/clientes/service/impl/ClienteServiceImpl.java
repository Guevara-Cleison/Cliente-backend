package com.example.clientes.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clientes.entity.Cliente;
import com.example.clientes.repository.ClienteRepository;
import com.example.clientes.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> consultarClientes() {
		
		return clienteRepository.findAll();
		
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		
		cliente.setFecha_creacion(LocalDateTime.now());
		
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	public void eliminarCliente(Long id) {
		clienteRepository.deleteById(id);
	}

}
