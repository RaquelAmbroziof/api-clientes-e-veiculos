package com.teste.clienteseveiculos.dto;

import com.teste.clienteseveiculos.entity.Perfil;

public record UsuarioUpdateDto(
		
		String nome, String endereco, Perfil perfil, String senha
		) {

}
