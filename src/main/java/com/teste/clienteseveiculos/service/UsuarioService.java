package com.teste.clienteseveiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.clienteseveiculos.entity.UsuarioEntity;
import com.teste.clienteseveiculos.exception.RegistroNotFoundException;
import com.teste.clienteseveiculos.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public UsuarioEntity save(UsuarioEntity cliente) {
		return repository.save(cliente);
	}
	
	public List<UsuarioEntity> findAll() {
		return repository.findAll();
	}
	
	public UsuarioEntity findById(Long id) throws RegistroNotFoundException {
		Optional<UsuarioEntity> user = repository.findById(id);
		if (!user.isPresent()) {
			throw new RegistroNotFoundException("Não existe usuário com id " + id);
		}
		return user.get();
	}
	
	public UsuarioEntity update(UsuarioEntity cliente, Long id) throws RegistroNotFoundException {
		findById(id);
		cliente.setId(id);
		return repository.save(cliente);
	}
	
	public void deleteById(Long id) throws RegistroNotFoundException {
		if (!repository.existsById(id)) {
			throw new RegistroNotFoundException("Não existe usuário com id " + id);
		}
		repository.deleteById(id);
	}

}
