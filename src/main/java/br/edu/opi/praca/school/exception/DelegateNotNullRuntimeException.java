package br.edu.opi.praca.school.exception;

public class DelegateNotNullRuntimeException extends SchoolConflictsRuntimeException {

	public DelegateNotNullRuntimeException() {
		super("Favor informar um Delegado");
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.DELEGATE_NOT_NULL;
	}

}
