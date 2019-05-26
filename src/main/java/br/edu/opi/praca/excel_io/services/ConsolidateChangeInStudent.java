package br.edu.opi.praca.excel_io.services;

import br.edu.opi.praca.excel_io.models.StudentTableRow;
import br.edu.opi.praca.student.service.StudentService;
import br.edu.opi.praca.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsolidateChangeInStudent extends Thread {

	private StudentTableRow student;
	private Long schoolId;

	@Autowired // don't remove, BeanUtil.autowire needs this
	private StudentService studentService;

	public ConsolidateChangeInStudent(Long schoolId, StudentTableRow student) {
		BeanUtil.autowire(this, this.studentService);
		this.student = student;
		this.schoolId = schoolId;
	}

	@Override
	public void run() {
		studentService.solveAndSave(schoolId, student);
	}

}
