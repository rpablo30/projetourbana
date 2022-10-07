package io.github.rpablo30.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.rpablo30.entity.Usuario;
import io.github.rpablo30.repository.UsuarioRepository;

@Service
public class UsuarioService {

	final UsuarioRepository clienteRepository;

	public UsuarioService(UsuarioRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Transactional
	public Usuario save(Usuario cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Usuario> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<Usuario> findById(Integer id) {
		return clienteRepository.findById(id);
	}

	@Transactional
	public void delete(Usuario cliente) {
		clienteRepository.delete(cliente);
	}

}
