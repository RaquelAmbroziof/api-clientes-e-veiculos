package com.teste.clienteseveiculos.entity;

public enum Perfil {
	ROLE_ADMINISTRADOR("administrador"), ROLE_CLIENTE("cliente");

	private String perfil;

	Perfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}

}
