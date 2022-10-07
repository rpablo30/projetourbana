package io.github.rpablo30.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RestController;

import io.github.rpablo30.dto.UsuarioDto;
import io.github.rpablo30.entity.Usuario;
import io.github.rpablo30.service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UsuarioController {

	final UsuarioService clienteService;

	public UsuarioController(UsuarioService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<Object> saveCliente(@RequestBody @Valid UsuarioDto clienteDto) {
		Usuario cliente = new Usuario();
		BeanUtils.copyProperties(clienteDto, cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));

	}

	@GetMapping
	public ResponseEntity<List<Usuario>> getAllCliente() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") Integer id) {
		Optional<Usuario> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Integer id) {
		Optional<Usuario> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		clienteService.delete(clienteOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado.");
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") Integer id,
			@RequestBody @Valid UsuarioDto clienteDto) {
		Optional<Usuario> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		Usuario cliente = new Usuario();
		BeanUtils.copyProperties(clienteDto, cliente);
		cliente.setId(clienteOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));

	}

}
