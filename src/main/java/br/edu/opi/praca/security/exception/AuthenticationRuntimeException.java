package br.edu.opi.praca.security.exception;

import br.edu.opi.praca.project_patterns.exceptions.ExceptionResponse;
import br.edu.opi.praca.project_patterns.exceptions.ExceptionWithErrorCode;

import java.time.Instant;

public abstract class AuthenticationRuntimeException extends RuntimeException implements ExceptionWithErrorCode {

	private static final long serialVersionUID = 849517067734494255L;

	public AuthenticationRuntimeException(String message) {
		super(message);
	}

	public ExceptionResponse getExceptionResponse() {
		return new ExceptionResponse(Instant.now(), this.getMessage(), this.getLocalizedMessage(), this.getErrorCode());
	}

}
