package br.edu.opi.praca.user.model;

import br.edu.opi.praca.security.exception.PasswordNotHashRuntimeException;
import br.edu.opi.praca.utils.BeanUtil;
import br.edu.opi.praca.utils.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Listener to Simple UserModel.
 */
public class UserListener {

	@Autowired
    CryptoUtil cryptoUtil;

	@PrePersist
	public void methodExecuteBeforeCreate(final UserModel user) {
		BeanUtil.autowire(this, this.cryptoUtil);
		if (this.cryptoUtil.isNotHashPassword(user.getPassword())) {
			user.setPassword(cryptoUtil.hashPassword(user.getPassword()));
		} else {
			throw new PasswordNotHashRuntimeException();
		}
	}

	@PreUpdate
	public void methodExecuteBeforeUpdate(final UserModel user) {
		BeanUtil.autowire(this, this.cryptoUtil);
		if (this.cryptoUtil.isNotHashPassword(user.getPassword())) {
			user.setPassword(cryptoUtil.hashPassword(user.getPassword()));
		}
	}

}
