package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class InvalidCpfRuntimeException extends ConflictsRuntimeException {
    public InvalidCpfRuntimeException(int cellNum, int numRow, String value) {
    }

    @Override
    public String getErrorCode() {
        return ErrorConstants.INVALID_CPF;
    }
}
