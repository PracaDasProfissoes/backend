package br.edu.opi.praca.student.dto;

import br.edu.opi.praca.person.models.Genre;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StudentInput {

    @ApiModelProperty(example = "José da Silva", required = true)
    @NotEmpty
    private String name;

    @ApiModelProperty(required = true)
    @NotNull
    private Genre genre;

    @ApiModelProperty(example = "1")
    private Long schoolId;

    @ApiModelProperty(example = "15")
    private Integer age;

    @ApiModelProperty(example = "Medicina")
    private String course;

    @ApiModelProperty(example = "1º ano do Ensino Médio")
    private String grade;

    public StudentInput() {
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

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
