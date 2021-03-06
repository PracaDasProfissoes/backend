package br.edu.opi.praca.school.exception;

public class DelegateNotFoundRuntimeException extends SchoolConflictsRuntimeException {

	public DelegateNotFoundRuntimeException(String id) {
		super("Delegado de identificador " + id + " não existe na base de dados");
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.DELEGATE_NOT_FOUND;
	}

}
