package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class InvalidRGRuntimeException extends ConflictsRuntimeException {
    public InvalidRGRuntimeException(int cellNum, int rowNum, String value) {
    }

    @Override
    public String getErrorCode() {
        return ErrorConstants.INVALID_RG;
    }
}
