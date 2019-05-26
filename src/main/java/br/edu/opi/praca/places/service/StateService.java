package br.edu.opi.praca.places.service;

import br.edu.opi.praca.places.model.State;
import br.edu.opi.praca.places.repository.StateRepository;
import br.edu.opi.praca.project_patterns.services.GenericService;
import org.springframework.stereotype.Service;

@Service
public class StateService extends GenericService<Long, State, StateRepository> {

	@Override
	public void validateBeforeCreate(State model) {
	}

	@Override
	public void validateBeforeUpdate(State model) {
	}

	@Override
	public void validateBeforeDelete(Long aLong) {
	}

}
