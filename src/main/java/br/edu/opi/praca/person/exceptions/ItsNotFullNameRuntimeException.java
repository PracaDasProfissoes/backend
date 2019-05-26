package br.edu.opi.praca.person.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class ItsNotFullNameRuntimeException extends ConflictsRuntimeException {

	public ItsNotFullNameRuntimeException() {
		super("Favor informar nome completo");
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.NOT_FULL_NAME;
	}

}
