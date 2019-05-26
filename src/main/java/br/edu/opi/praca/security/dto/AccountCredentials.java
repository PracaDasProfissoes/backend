package br.edu.opi.praca.security.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * Credentials of the Account.
 */
@ApiModel(value = "AccountCredentials")
public class AccountCredentials {

	@ApiModelProperty(example = "administrador@email.com", required = true)
	@NotEmpty
	private String username;

	@ApiModelProperty(example = "P@ssw0rd", required = true)
	@NotEmpty
	private String password;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
