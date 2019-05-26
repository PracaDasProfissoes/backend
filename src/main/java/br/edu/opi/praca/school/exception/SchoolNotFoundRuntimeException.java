package br.edu.opi.praca.school.exception;

import br.edu.opi.praca.project_patterns.exceptions.ConflictsRuntimeException;

public class SchoolNotFoundRuntimeException extends ConflictsRuntimeException {

    public SchoolNotFoundRuntimeException() {
        super("Escola não encontrada");
    }

    @Override
    public String getErrorCode() {
        return ErrorConstants.SCHOOL_NOT_NULL;
    }

}
