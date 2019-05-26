package br.edu.opi.praca.delegate.exception;

import br.edu.opi.praca.project_patterns.exceptions.ExceptionWithErrorCode;

public abstract class DelegateConflictRuntimeException extends RuntimeException implements ExceptionWithErrorCode {

	public DelegateConflictRuntimeException(String message) {
		super(message);
	}

}
