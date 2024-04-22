package com.teste.clienteseveiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.clienteseveiculos.entity.VeiculoEntity;
import com.teste.clienteseveiculos.exception.RegistroNotFoundException;
import com.teste.clienteseveiculos.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	VeiculoService service;

	@PostMapping("/cliente/{id}")
	public ResponseEntity<VeiculoEntity> save(@PathVariable Long id,
			@Validated @RequestBody VeiculoEntity veiculo) {
		return new ResponseEntity<VeiculoEntity>(service.save(id, veiculo), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<VeiculoEntity>> findAll() {
		return new ResponseEntity<List<VeiculoEntity>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VeiculoEntity> findById(@PathVariable Long id) throws RegistroNotFoundException {
		return new ResponseEntity<VeiculoEntity>(service.findById(id), HttpStatus.OK);
	}

}
