package br.edu.opi.praca.school.dto;

import io.swagger.annotations.ApiModelProperty;

public class SchoolOutput {

	@ApiModelProperty(example = "1")
	private Long id;

	@ApiModelProperty(example = "Colégio de Teste")
	private String schoolName;

	@ApiModelProperty(example = "Campina Grande")
	private Long schoolCityCbo;

	@ApiModelProperty(example = "user@user.com")
	private String delegateEmail;

	@ApiModelProperty(example = "Jose")
	private String delegateName;

	@ApiModelProperty(example = "+55 55 55555-5555")
	private String delegatePhone;

	@ApiModelProperty(example = "true")
	private boolean enabled;

	@ApiModelProperty(name = "50.489.678/0001-58")
	private String cnpj;

	@ApiModelProperty(name = "CT")
	private String sigla;

	@ApiModelProperty(name = "Avenida avenida")
	private String streetName;

	@ApiModelProperty(name = "58419=275")
	private String cep;

	public SchoolOutput() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDelegatePhone() {
		return delegatePhone;
	}

	public void setDelegatePhone(String delegatePhone) {
		this.delegatePhone = delegatePhone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
