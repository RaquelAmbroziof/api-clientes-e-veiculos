package com.teste.clienteseveiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.teste.clienteseveiculos.dto.CadastroUsuarioDto;
import com.teste.clienteseveiculos.dto.LoginDto;
import com.teste.clienteseveiculos.dto.LoginResponseDto;
import com.teste.clienteseveiculos.dto.UsuarioUpdateDto;
import com.teste.clienteseveiculos.entity.UsuarioEntity;
import com.teste.clienteseveiculos.exception.RegistroNotFoundException;
import com.teste.clienteseveiculos.repository.UsuarioRepository;
import com.teste.clienteseveiculos.security.TokenService;

import jakarta.validation.Valid;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;

	@Lazy
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	public ResponseEntity<Object> save(CadastroUsuarioDto usuario) {
		if (repository.findByCnpj(usuario.cnpj()) != null)
			return ResponseEntity.badRequest().build();
		String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.senha());
		UsuarioEntity novoCli = UsuarioEntity.builder().nome(usuario.nome()).cnpj(usuario.cnpj())
				.endereco(usuario.endereco()).senha(encryptedPassword).perfil(usuario.perfil()).build();
		UsuarioEntity novo = repository.save(novoCli);
		return ResponseEntity.ok().body(novo);

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

	public UsuarioEntity update(Long id, UsuarioUpdateDto update) {
		UsuarioEntity usu = findById(id);
		if (update.nome() != null && !update.nome().isEmpty()) {
			usu.setNome(update.nome());
		}
		if (update.endereco() != null && !update.endereco().isEmpty()) {
			usu.setEndereco(update.endereco());
		}
		if (update.perfil() != null) {
			usu.setPerfil(update.perfil());
		}
		if (update.senha() != null && !update.senha().isEmpty()) {
			usu.setSenha(update.senha());
		}
		return repository.save(usu);
	}

	public void deleteById(Long id) throws RegistroNotFoundException {
		if (!repository.existsById(id)) {
			throw new RegistroNotFoundException("Não existe usuário com id " + id);
		}
		repository.deleteById(id);
	}

	public ResponseEntity<Object> login(@RequestBody @Valid LoginDto data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.cnpj(), data.senha());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDto(token));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByCnpj(username);
	}

}
