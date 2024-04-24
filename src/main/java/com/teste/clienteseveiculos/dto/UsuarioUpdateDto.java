package com.teste.clienteseveiculos.dto;

import com.teste.clienteseveiculos.util.Perfil;

public record UsuarioUpdateDto(String nome, String endereco, Perfil perfil, String senha) {

}
