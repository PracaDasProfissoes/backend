package br.edu.opi.praca.student.service;

import br.edu.opi.praca.excel_io.models.StudentTableRow;
import br.edu.opi.praca.project_patterns.exceptions.NotFoundRuntimeException;
import br.edu.opi.praca.project_patterns.services.GenericService;
import br.edu.opi.praca.school.model.Grade;
import br.edu.opi.praca.school.model.School;
import br.edu.opi.praca.school.repository.SchoolRepository;
import br.edu.opi.praca.school.service.SchoolService;
import br.edu.opi.praca.student.exceptions.SchoolNotNullRuntimeException;
import br.edu.opi.praca.student.model.Student;
import br.edu.opi.praca.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.edu.opi.praca.person.models.Genre;
import br.edu.opi.praca.person.models.PartsPersonName;
import br.edu.opi.praca.person.models.Person;
import br.edu.opi.praca.person.services.PersonService;

import java.util.List;

@Service
public class StudentService extends GenericService<Long, Student, StudentRepository> {

    private SchoolRepository schoolRepository;

    private PersonService personService;

    private SchoolService schoolService;

    @Autowired
    public StudentService(
            SchoolRepository schoolRepository,
            PersonService personService,
            SchoolService schoolService) {
        this.schoolRepository = schoolRepository;
        this.personService = personService;
        this.schoolService = schoolService;
    }

    public Page<Student> index(Integer page, Integer size, String delegatePrincipal) {
        School school = schoolRepository.findByDelegateUsername(delegatePrincipal);
        if (school == null) {
            throw new SchoolNotNullRuntimeException(delegatePrincipal);
        }
        if (page == null) {
            page = DEFAULT_PAGE;
        }
        if (size == null) {
            size = DEFAULT_SIZE;
        }
        return repository.findAllBySchoolId(school.getId(), PageRequest.of(page, size, DEFAULT_SORT));
    }

    public Student show(Long id, String delegatePrincipal) {
        School school = schoolRepository.findByDelegateUsername(delegatePrincipal);
        if (school == null) {
            throw new SchoolNotNullRuntimeException(delegatePrincipal);
        }
        Student savedStudent = repository.findByIdAndSchoolId(id, school.getId());
        if (savedStudent == null) {
            throw new NotFoundRuntimeException();
        }
        return savedStudent;
    }

    public void create(List<Student> students) {
        for (Student student : students) {
            this.create(student);
        }
    }

    public Student create(Student student){
        validateBeforeCreate(student);
        return repository.save(student);
    }

    public Student create(Student student, String delegatePrincipal) {
        School school = schoolRepository.findByDelegateUsername(delegatePrincipal);
        if (school == null) {
            throw new SchoolNotNullRuntimeException(student.getPerson().getFullName());
        }
        student.setSchool(new School(school.getId()));
        return this.create(student);
    }

    public void create(List<Student> students, String delegatePrincipal) {
        School school = schoolRepository.findByDelegateUsername(delegatePrincipal);
        if (school == null) {
            throw new SchoolNotNullRuntimeException(delegatePrincipal);
        }
        // TODO: try change front in future
        List<Student> listToRemove = repository.findAllBySchoolId(school.getId());
        repository.deleteAll(listToRemove); // TODO: performance
        // TODO: try change front in future
        school = new School(school.getId());
        for (Student student : students) {
            student.setSchool(school);
            this.create(student);
        }
    }

    public Student update(Long id, Student student, String delegatePrincipal) {
        show(id, delegatePrincipal);
        return this.update(id, student);
    }

    public void delete(Long id, String delegatePrincipal) {
        show(id, delegatePrincipal);
        this.delete(id);
    }



    public void solveAndSave(Long schoolId, StudentTableRow studentTableRow) {
        PartsPersonName parts = personService.processName(studentTableRow.getName());
        List<Student> listSavedStudent = repository
                .findByPersonFirstNameAndPersonLastName(
                        parts.getFirstName(),
                        parts.getLastName());
        Student savedStudent = !listSavedStudent.isEmpty() ? listSavedStudent.get(0) : null; // TODO: if size > 0?
        String name = studentTableRow.getName();
        Genre genre = studentTableRow.getGenre();
        Student student = new Student(new Person(name, genre), new School(schoolId), "", 10, Grade.FIRST_HIGH);
        if (savedStudent == null) {
            create(student);
        } else {
            update(savedStudent.getId(), student);
        }
    }

    @Override
    public void validateBeforeCreate(Student student) {
        School school = schoolService.show(student.getSchool().getId());
        student.setSchool(school);
    }

    @Override
    public void validateBeforeUpdate(Student student) {
    }

    @Override
    public void validateBeforeDelete(Long id) {
    }

}
