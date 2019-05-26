package br.edu.opi.praca.school.model;

import br.edu.opi.praca.delegate.model.Delegate;
import br.edu.opi.praca.places.model.Address;
import br.edu.opi.praca.places.model.City;
import br.edu.opi.praca.project_patterns.models.Model;
import br.edu.opi.praca.project_patterns.models.history.Auditing;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_school")
public class School extends Auditing implements Serializable, Model<Long> {

	private static final long serialVersionUID = -9051052759732137812L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_cbo_code", nullable = false)
	private City city;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delegate_id", nullable = false)
	private Delegate delegate;

	@Column(name = "enabled", nullable = false)
	private boolean enabled = false;

	@Column(name = "sigla")
	private String sigla;

	@Column(name = "cnpj")
	private String cnpj;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	@Column(name = "filled")
	private boolean filled = false;

	@Column(name = "is_public", nullable = false)
	private boolean isPublic = false;


	public School() {
	}

	public School(Long id) {
		this.id = id;
	}

	public School(String name, City city, Delegate delegate, Address address) {
		this.name = name;
		this.city = city;
		this.delegate = delegate;
		this.address = address;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Delegate getDelegate() {
		return delegate;
	}

	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean aPublic) {
		isPublic = aPublic;
	}
}
