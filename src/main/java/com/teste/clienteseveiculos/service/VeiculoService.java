package com.teste.clienteseveiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.clienteseveiculos.entity.UsuarioEntity;
import com.teste.clienteseveiculos.entity.VeiculoEntity;
import com.teste.clienteseveiculos.exception.RegistroNotFoundException;
import com.teste.clienteseveiculos.repository.UsuarioRepository;
import com.teste.clienteseveiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	VeiculoRepository repository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public VeiculoEntity save(Long idUsuario, VeiculoEntity veiculo) {
		Optional<UsuarioEntity> clienteOpt = usuarioRepository.findById(idUsuario);
		UsuarioEntity proprietarioVeiculo = clienteOpt.get();

		veiculo.setProprietario(proprietarioVeiculo);
		VeiculoEntity veiculoAdd = repository.save(veiculo);

		proprietarioVeiculo.getVeiculos().add(veiculoAdd);
		usuarioRepository.save(proprietarioVeiculo);

		return repository.save(veiculo);
	}
	
	public List<VeiculoEntity> findAll() throws RegistroNotFoundException{
		return repository.findAll();
	}
	
	public VeiculoEntity findById(Long id) {
		Optional<VeiculoEntity> veiculo = repository.findById(id);
		if (!veiculo.isPresent()) {
			throw new RegistroNotFoundException("Não existe veiculo com id " + id);
		}
		return veiculo.get();
	}

}
