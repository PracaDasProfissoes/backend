package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class InvalidFileRuntimeException extends ConflictsRuntimeException {

	public InvalidFileRuntimeException() {
		super("Arquivo inválido. Favor preencher modelo disponível no site da OPI e submetê-lo em seguida.");
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.INVALID_FILE;
	}
}
