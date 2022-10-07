package io.github.rpablo30.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioDto {

	
	private String nome;
	
	
	@Email
	private String email;
	
	
	private String tipo;
}
