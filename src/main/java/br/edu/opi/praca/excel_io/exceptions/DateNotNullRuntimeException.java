package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class DateNotNullRuntimeException extends ConflictsRuntimeException {

	public DateNotNullRuntimeException(int cellNum, int rowNum) {
		super("É preciso informar uma data válida. Célula: " + ExceptionsUtils.solveLetterColumn(cellNum) + rowNum);
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.DATE_NOT_NULL;
	}

}