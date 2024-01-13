package com.example.clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientes.entity.Cliente;
import com.example.clientes.service.ClienteService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@RequestMapping(value = "consultarClientes", method = RequestMethod.GET)
	public ResponseEntity<?> consultarClientes(){
		
		List<Cliente> clientesConsultados = this.clienteService.consultarClientes();
		
		return ResponseEntity.ok(clientesConsultados);
	}
	
	@PostMapping
	@RequestMapping(value = "guardarCliente", method = RequestMethod.POST)
	public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente){
		
		Cliente clienteGuardado = clienteService.guardarCliente(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteGuardado);
	}
	
	@PutMapping
	@RequestMapping(value = "actualizarCliente", method = RequestMethod.PUT)
	public ResponseEntity<?> ActualizarCliente(@RequestBody Cliente cliente){
		
		Cliente clienteActualizado = clienteService.actualizarCliente(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteActualizado);
	}
	
	@DeleteMapping
	@RequestMapping(value = "eliminarCliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> EliminarCliente(@PathVariable Long id){
		
		clienteService.eliminarCliente(id);
		
		return ResponseEntity.ok().build();
	}

}
