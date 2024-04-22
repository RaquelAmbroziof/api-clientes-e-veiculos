package com.teste.clienteseveiculos.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório!")
	@Column(nullable = false)
	private String nome;

	@NotBlank(message = "Cnpj é obrigatório!")
	@Column(nullable = false, unique = true)
	private String cnpj;

	@NotBlank(message = "Endereço é obrigatório!")
	@Column(nullable = false)
	private String endereco;

	@OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
	private Set<VeiculoEntity> veiculos;

}
