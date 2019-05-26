package br.edu.opi.praca.places.model;

import br.edu.opi.praca.project_patterns.models.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adress")
public class Address implements Serializable, Model<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String streetName;

    @Column(name = "cep")
    private String cep;

    @Column(name = "num_school")
    private String buildingNumber;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    private City uf;

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    public Address(Long id, String streetName, String cep, String buildingNumber, City uf) {
        this.id = id;
        this.streetName = streetName;
        this.cep = cep;
        this.buildingNumber = buildingNumber;
        this.uf = uf;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public City getUf() {
        return uf;
    }

    public void setUf(City uf) {
        this.uf = uf;
    }
}
