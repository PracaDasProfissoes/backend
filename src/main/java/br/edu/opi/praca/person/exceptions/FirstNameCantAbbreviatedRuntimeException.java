package br.edu.opi.praca.person.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class FirstNameCantAbbreviatedRuntimeException extends ConflictsRuntimeException {

	public FirstNameCantAbbreviatedRuntimeException() {
		super("Primeiro nome não pode ser abreviado");
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.FIRST_NAME_ERROR;
	}

}
