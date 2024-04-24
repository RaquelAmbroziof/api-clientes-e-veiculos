package com.teste.clienteseveiculos.dto;

import com.teste.clienteseveiculos.entity.Perfil;

public record CadastroDto(

		String nome, String cnpj, String endereco, Perfil perfil, String senha

) {

}
