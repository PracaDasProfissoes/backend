package br.edu.opi.praca.person.models;

import br.edu.opi.praca.project_patterns.models.Model;
import br.edu.opi.praca.project_patterns.models.history.Auditing;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tb_person", indexes = {@Index(name = "IDX_SOLVE_NAME", columnList = "first_name, last_name")})
@EntityListeners(PersonListener.class)
public class Person extends Auditing implements Serializable, Model<Long> {

	private static final long serialVersionUID = 5590418866770917000L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotEmpty
	@Column(name = "full_name", nullable = false)
	private String fullName;

	@NotEmpty
	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;

	@NotEmpty
	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName;


	@Column(name = "age")
	private Integer age;

	@NotNull
	@Column(name = "genre", nullable = false)
	private Genre genre;

	public Person() {
	}

	public Person(String fullName, Genre genre) {
		this.fullName = fullName;
		this.genre = genre;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
