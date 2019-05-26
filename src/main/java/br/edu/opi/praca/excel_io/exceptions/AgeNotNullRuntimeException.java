package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class AgeNotNullRuntimeException extends ConflictsRuntimeException {
    public AgeNotNullRuntimeException(int cellNum, int rowNum) {
        super("É preciso informar uma idade válida");
    }

    @Override
    public String getErrorCode() {
        return ErrorConstants.AGE_NOT_NULL;
    }
}
