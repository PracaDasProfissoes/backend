package br.edu.opi.praca.excel_io.exceptions;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class CpfNotNullRuntimeException extends ConflictsRuntimeException {
    public CpfNotNullRuntimeException(int cellNum, int rowNumm) {
        super("");
    }

    @Override
    public String getErrorCode() {
        return ErrorConstants.CPF_NOT_NULL;
    }
}
