package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class GenreNotNullRuntimeException extends ConflictsRuntimeException {

	public GenreNotNullRuntimeException(int cellNum, int rowNum) {
		super("É preciso informar um gênero válido. Célula: " + ExceptionsUtils.solveLetterColumn(cellNum) + rowNum);
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.GENRE_NOT_NULL;
	}
}