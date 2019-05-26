package br.edu.opi.praca.school.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;

@ApiModel(value = "schoolInput")
public class SchoolInput {

	@ApiModelProperty(example = "Colégio de Teste", required = true)
	private String schoolName;

	@ApiModelProperty(example = "2504009", required = true)
	private Long schoolCityCbo;

	@Email
	@ApiModelProperty(example = "delegate@email.com", required = true)
	private String delegateEmail;

	@ApiModelProperty(example = "Delegado Exemplo")
	private String delegateName;

	@ApiModelProperty(example = "abcde")
	private String password;

	@ApiModelProperty(name = "50.489.678/0001-58")
	private String cnpj;

	@ApiModelProperty(name = "CT")
	private String sigla;

	@ApiModelProperty(name = "Avenida avenida")
	private String streetName;

	@ApiModelProperty(name = "58419=275")
	private String cep;

	public SchoolInput() {
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Long getSchoolCityCbo() {
		return schoolCityCbo;
	}

	public void setSchoolCityCbo(Long schoolCityCbo) {
		this.schoolCityCbo = schoolCityCbo;
	}

	public String getDelegateEmail() {
		return delegateEmail;
	}

	public void setDelegateEmail(String delegateEmail) {
		this.delegateEmail = delegateEmail;
	}

	public String getDelegateName() {
		return delegateName;
	}

	public void setDelegateName(String delegateName) {
		this.delegateName = delegateName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
