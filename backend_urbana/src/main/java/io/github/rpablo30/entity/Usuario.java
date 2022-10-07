package io.github.rpablo30.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cadastro")
@Setter
@Getter
public class Usuario{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 255)
	private String nome;
	
	@Email
	@Column(nullable = false, length = 255)
	private String email;
	
	@Column(nullable = false)
	private String tipo;

	public Usuario(String nome,String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.tipo	 = telefone;
	}

	public Usuario() {
		
	}

	
	
}
