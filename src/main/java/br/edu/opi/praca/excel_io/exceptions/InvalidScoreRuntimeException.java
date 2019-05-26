package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class InvalidScoreRuntimeException extends ConflictsRuntimeException {

	public InvalidScoreRuntimeException(int cellNum, int rowNum, String value) {
		super("Pontuação '" + value + "' inválida. Pontuação deve ser um número real ou informe de que o aluno FALTOU. Célula: " + ExceptionsUtils.solveLetterColumn(cellNum) + rowNum);
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.INVALID_SCORE;
	}

}