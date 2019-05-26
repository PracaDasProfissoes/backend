package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class InvalidAgeRuntimeException extends ConflictsRuntimeException {
    public InvalidAgeRuntimeException(int cellNum, int rowNum, String value) {
        super("Idade" + value + "inválida. A idade deve ser um número natural menor que 99. Célula:" + ExceptionsUtils.solveLetterColumn(cellNum) + rowNum);
    }

    @Override
    public String getErrorCode() {
        return ErrorConstants.INVALID_AGE;
    }
}
