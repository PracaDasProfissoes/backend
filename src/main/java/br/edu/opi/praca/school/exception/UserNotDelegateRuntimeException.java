package br.edu.opi.praca.school.exception;

public class UserNotDelegateRuntimeException extends SchoolConflictsRuntimeException {

	public UserNotDelegateRuntimeException() {
		super("Este usuário tem outra função e não está habilitado para ser um Delegado");
	}

	public UserNotDelegateRuntimeException(String userName) {
		super("O usuário " + userName + " tem outra função e não está habilitado para ser um Delegado");
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.USER_NOT_DELEGATE;
	}

}
