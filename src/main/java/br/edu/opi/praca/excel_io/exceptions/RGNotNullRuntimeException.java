package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class RGNotNullRuntimeException extends ConflictsRuntimeException {
    public RGNotNullRuntimeException(int cellNum, int rowNum) {
    }

    @Override
    public String getErrorCode() {
        return ErrorConstants.RG_NOT_NULL;
    }
}
