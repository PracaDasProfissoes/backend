package br.edu.opi.praca.places.dto;

import io.swagger.annotations.ApiModelProperty;

public class AddressInput {

    @ApiModelProperty(example = "")
    private String streetName;

    @ApiModelProperty(example = "")
    private String cep;

    @ApiModelProperty(example = "")
    private String buildingNumber;

    @ApiModelProperty(example = "2504009", required = true)
    private Long schoolCityCbo;

    public AddressInput() {
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

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Long getSchoolCityCbo() {
        return schoolCityCbo;
    }

    public void setSchoolCityCbo(Long schoolCityCbo) {
        this.schoolCityCbo = schoolCityCbo;
    }
}
