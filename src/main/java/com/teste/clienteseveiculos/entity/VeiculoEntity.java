package com.teste.clienteseveiculos.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "VEICULO")
public class VeiculoEntity implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Placa é obrigatório!")
	@Column(nullable = false, unique = true)
	private String placa;

	@NotBlank(message="Modelo é obrigatório!")
	@Column(nullable = false)
	private String modelo;

	@NotBlank(message="Serial rastreador é obrigatório!")
	@Column(nullable = false, unique = true)
	private String serialRastreador;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "cliente_id", nullable = false)
	private UsuarioEntity proprietario;

}
