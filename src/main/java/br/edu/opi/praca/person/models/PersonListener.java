package br.edu.opi.praca.person.models;

import br.edu.opi.praca.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import br.edu.opi.praca.person.services.PersonService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class PersonListener {

	@Autowired // don't remove, BeanUtil.autowire needs this
			PersonService personService;

	@PrePersist
	@PreUpdate
	public void executeBeforeSave(Person person) {
		BeanUtil.autowire(this, this.personService);
		person.setFullName(person.getFullName().trim());
		String fullName = person.getFullName();
		PartsPersonName parts = personService.processName(fullName);
		person.setFirstName(parts.getLastName());
		person.setLastName(parts.getLastName());
	}

}
