package com.teste.clienteseveiculos.dto;

import com.teste.clienteseveiculos.util.Perfil;

public record CadastroUsuarioDto(String nome, String cnpj, String endereco, Perfil perfil, String senha) {

}
