package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class GradeNotNullRuntimeException extends ConflictsRuntimeException {

	public GradeNotNullRuntimeException(int cellNum, int rowNum) {
		super("É preciso informar uma série válida. Célula: " + ExceptionsUtils.solveLetterColumn(cellNum) + rowNum);
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.GRADE_NOT_NULL;
	}

}