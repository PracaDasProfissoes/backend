package br.edu.opi.praca.student.model;

import br.edu.opi.praca.person.models.Person;
import br.edu.opi.praca.project_patterns.models.Model;
import br.edu.opi.praca.project_patterns.models.history.Auditing;
import br.edu.opi.praca.school.model.Grade;
import br.edu.opi.praca.school.model.School;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_student")
public class Student extends Auditing implements Serializable, Model<Long> {

	private static final long serialVersionUID = -9051052759732137812L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "person_id", updatable = false)
	private Person person;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id", updatable = false)
	private School school;

	@Column(name = "enabled", nullable = false)
	private boolean enabled = true;

	@Column(name = "age")
	private Integer age;

	@Enumerated(EnumType.STRING)
	@Column(name = "grade", nullable = false)
	private Grade grade;

	@Column(name = "course")
	private String course;

	public Student() {
	}

	public Student(Long id) {
		this.id = id;
	}

	public Student(Person person, School school, String course, Integer age, Grade grade) {
		this.person = person;
		this.school = school;
		this.course = course;
		this.age = age;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
