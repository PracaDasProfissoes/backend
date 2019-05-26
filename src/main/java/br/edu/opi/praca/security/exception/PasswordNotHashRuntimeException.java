package br.edu.opi.praca.security.exception;

public class PasswordNotHashRuntimeException extends AuthenticationRuntimeException {

	public PasswordNotHashRuntimeException() {
		super("Senha não pode ser um hash");
	}

	@Override
	public String getErrorCode() {
		return ErrorConstants.PASSWORD_NOT_HASH;
	}

}
