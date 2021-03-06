package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class ScoreNotNullRuntimeException extends ConflictsRuntimeException {

	public ScoreNotNullRuntimeException(int cellNum, int rowNum) {
		super("É preciso informar pontuação válida ou informar que o aluno FALTOU. Célula: " + ExceptionsUtils.solveLetterColumn(cellNum) + rowNum);
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.SCORE_NOT_NULL;
	}

}