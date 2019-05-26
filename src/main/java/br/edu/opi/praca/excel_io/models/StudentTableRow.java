package br.edu.opi.praca.excel_io.models;

import br.edu.opi.praca.project_patterns.models.Model;
import br.edu.opi.praca.project_patterns.models.history.Auditing;
import br.edu.opi.praca.person.models.Genre;
import br.edu.opi.praca.school.model.Grade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_student_table_row")
public class StudentTableRow extends Auditing implements Serializable, Model<Long> {

	private static final long serialVersionUID = 3030331999726512470L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "genre", nullable = false)
	private Genre genre;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "RG")
	private String rg;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "grade")
	private Grade grade;

	@Column(name = "turno")
	private String turno;

	@Column(name = "course")
	private String course;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_table_metadata_id")
	private StudentTableMetadata studentTableMetadata;

	public StudentTableRow() {
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public StudentTableMetadata getStudentTableMetadata() {
		return studentTableMetadata;
	}

	public void setStudentTableMetadata(StudentTableMetadata studentTableMetadata) {
		this.studentTableMetadata = studentTableMetadata;
	}

	@Override
	public String toString() {
		return "StudentTableRow{" +
				"name='" + name + '\'' +
				", genre=" + genre +
				", age=" + age +
				", rg=" + rg +
				", cpf=" + cpf +
				", grade=" + grade +
				", turno='" + turno + '\'' +
				", course='" + course + '\'' +
				'}';
	}

}
