package com.teste.clienteseveiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.clienteseveiculos.dto.CadastroDto;
import com.teste.clienteseveiculos.dto.LoginDto;
import com.teste.clienteseveiculos.dto.LoginResponseDto;
import com.teste.clienteseveiculos.entity.UsuarioEntity;
import com.teste.clienteseveiculos.exception.RegistroNotFoundException;
import com.teste.clienteseveiculos.repository.UsuarioRepository;
import com.teste.clienteseveiculos.security.TokenService;
import com.teste.clienteseveiculos.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioService usuarioService;

	@Lazy
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private ApplicationContext context;

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> save(@Validated @RequestBody CadastroDto usuario) {
		if (this.usuarioRepository.findByCnpj(usuario.cnpj()) != null)
			return ResponseEntity.badRequest().build();
		String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.senha());

		UsuarioEntity novoCli = UsuarioEntity.builder().nome(usuario.nome()).cnpj(usuario.cnpj())
				.endereco(usuario.endereco()).senha(encryptedPassword).perfil(usuario.perfil()).build();

		usuarioRepository.save(novoCli);

		return ResponseEntity.ok().build();
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginDto data) {
//		var usernamePassword = new UsernamePasswordAuthenticationToken(data.cnpj(), data.senha());
//
//		var auth = this.authenticationManager.authenticate(usernamePassword);
//
//		var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());
//
//		return ResponseEntity.ok(new LoginResponseDto(token));
//
//	}
	
	 @PostMapping("/login")
	    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto authetinticationDto){
	        return usuarioService.login(authetinticationDto);
	    }

	@GetMapping
	public ResponseEntity<List<UsuarioEntity>> findAll() {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioEntity> findById(@PathVariable Long id) throws RegistroNotFoundException {
		return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioEntity> update(@PathVariable Long id, @Valid @RequestBody UsuarioEntity cliente) {
		return new ResponseEntity<UsuarioEntity>(usuarioService.update(cliente, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws RegistroNotFoundException {
		usuarioService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
