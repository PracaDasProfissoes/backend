package br.edu.opi.praca.school.exception;

import br.edu.opi.praca.project_patterns.exceptions.ExceptionWithErrorCode;

public abstract class SchoolConflictsRuntimeException extends RuntimeException implements ExceptionWithErrorCode {

	public SchoolConflictsRuntimeException(String message) {
		super(message);
	}

}
