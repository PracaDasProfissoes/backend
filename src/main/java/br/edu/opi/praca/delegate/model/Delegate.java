package br.edu.opi.praca.delegate.model;

import br.edu.opi.praca.project_patterns.models.user.ProfileFactory;
import br.edu.opi.praca.user.model.UserModel;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@ApiIgnore
@Entity
@Table(name = "tb_delegate")
@PrimaryKeyJoinColumn(name = "id")
@EntityListeners(DelegateListener.class)
public class Delegate extends UserModel {

	private static final long serialVersionUID = -9051052759732137812L;

	@Column(name = "phone")
	private String phone;

	public Delegate() {
	}

	public Delegate(Long delegateId) {
		super(delegateId);
	}

	public Delegate(Long delegateId, String delegateUsername) {
		super(delegateId);
		super.setUsername(delegateUsername);
	}

	public Delegate(Long delegateId, String delegateEmail, String delegateName) {
		super(delegateId);
		super.setUsername(delegateEmail);
		super.setName(delegateName);
		super.setProfile(ProfileFactory.delegateUser());
	}

	public Delegate(Long delegateId, String delegateEmail, String delegateName, String password) {
		super(delegateId);
		super.setUsername(delegateEmail);
		super.setName(delegateName);
		super.setProfile(ProfileFactory.delegateUser());
		super.setPassword(password);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
