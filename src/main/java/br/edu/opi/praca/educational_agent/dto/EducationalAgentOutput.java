package br.edu.opi.praca.educational_agent.dto;

import io.swagger.annotations.ApiModelProperty;

public class EducationalAgentOutput {

    @ApiModelProperty(name = "1")
    private Long id;

    @ApiModelProperty(name = "")
    private String cpf;

    @ApiModelProperty(name = "12345678900")
    private String rg;

    @ApiModelProperty(name = "58000110")
    private String cep;

    @ApiModelProperty(name = "1")
    private Long cityCbo;



    public EducationalAgentOutput() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getCityCbo() {
        return cityCbo;
    }

    public void setCityCbo(Long cityCbo) {
        this.cityCbo = cityCbo;
    }
}
