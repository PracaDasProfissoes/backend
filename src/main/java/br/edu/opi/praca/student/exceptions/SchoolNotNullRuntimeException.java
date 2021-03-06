package br.edu.opi.praca.student.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

import java.time.LocalDate;

public class SchoolNotNullRuntimeException extends ConflictsRuntimeException {

	private static final long serialVersionUID = -8855688573022904276L;

	public SchoolNotNullRuntimeException(String delegatePrincipal) {
		super("Delegado " + delegatePrincipal + " não está relacionado com escola alguma");
	}

	public SchoolNotNullRuntimeException(String name, LocalDate dateBirth) {
		super("Favor informar Escola válida para estudante " + name + " nascido em " + dateBirth.getDayOfMonth() + "/" + dateBirth.getMonthValue() + "/" + dateBirth.getYear());
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.SCHOOL_NOT_NULL;
	}

}
