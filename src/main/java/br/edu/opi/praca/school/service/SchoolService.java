package br.edu.opi.praca.school.service;

import br.edu.opi.praca.delegate.model.Delegate;
import br.edu.opi.praca.delegate.repository.DelegateRepository;
import br.edu.opi.praca.delegate.service.DelegateService;
import br.edu.opi.praca.places.model.Address;
import br.edu.opi.praca.places.service.AddressService;
import br.edu.opi.praca.project_patterns.services.GenericService;
import br.edu.opi.praca.school.exception.DelegateNotNullRuntimeException;
import br.edu.opi.praca.school.exception.SchoolExistsRuntimeException;
import br.edu.opi.praca.school.exception.SchoolNotFoundRuntimeException;
import br.edu.opi.praca.school.model.School;
import br.edu.opi.praca.school.repository.SchoolRepository;
import br.edu.opi.praca.student.exceptions.SchoolNotNullRuntimeException;
import br.edu.opi.praca.user.model.UserModel;
import br.edu.opi.praca.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService extends GenericService<Long, School, SchoolRepository> {

	private DelegateService delegateService;

	private DelegateRepository delegateRepository;

	private UserRepository userRepository;

	private AddressService addressService;

	@Autowired
	public SchoolService(
			DelegateRepository delegateRepository,
			DelegateService delegateService,
			UserRepository userRepository,
			AddressService addressService) {
		this.delegateRepository = delegateRepository;
		this.delegateService = delegateService;
		this.userRepository = userRepository;
		this.addressService = addressService;
	}


	public School show(String delegatePrincipal) {
		School school = repository.findByDelegateUsername(delegatePrincipal);
		if (school == null) {
			throw new SchoolNotNullRuntimeException(delegatePrincipal);
		}
		return school;
	}

	public School update(Long id, School school, String delegatePrincipal) {
		School savedSchool = repository.findByDelegateUsername(delegatePrincipal);
		if (savedSchool == null) {
			throw new SchoolNotNullRuntimeException(delegatePrincipal);
		}
		return this.update(savedSchool.getId(), school);
	}

	public School update(Long id, boolean filled) {
		School savedSchool = repository.findById(id).orElseThrow(SchoolNotFoundRuntimeException::new);
		savedSchool.setFilled(filled);
		return this.update(id, savedSchool);
	}

	@Override
	public void validateBeforeCreate(School school) {
		solveSchool(school);
		solveCommonUser(school);
		solveDelegate(school);
		solveAddress(school);
	}

	@Override
	public void validateBeforeUpdate(School school) {
		solveDelegate(school);
	}

	@Override
	public void validateBeforeDelete(Long aLong) {
	}

	private void solveCommonUser(School school) {
		Delegate delegate = school.getDelegate();
		if (delegate == null || delegate.getUsername() == null) {
			throw new DelegateNotNullRuntimeException();
		}
		UserModel user = userRepository.findByUsername(delegate.getUsername());
//		if (user != null) {
//			throw new UserNotDelegateRuntimeException();
//		}
	}

	private void solveSchool(School school) {
		Delegate delegate = school.getDelegate();
		if (delegate == null || delegate.getUsername() == null) {
			throw new DelegateNotNullRuntimeException();
		}
		School savedSchool = repository.findByDelegateUsername(delegate.getUsername());
		if (savedSchool != null) {
			throw new SchoolExistsRuntimeException(savedSchool.getName());
		}
	}

	private void solveDelegate(School school) {
		Delegate delegate = school.getDelegate();
		if (delegate == null || delegate.getUsername() == null) {
			throw new DelegateNotNullRuntimeException();
		}
		Delegate savedDelegate = delegateRepository.findByUsername(delegate.getUsername());
		if (savedDelegate != null) {
			delegate = delegateService.update(savedDelegate.getId(), delegate);
		} else {
			delegate = delegateService.create(delegate);
		}
		school.setDelegate(new Delegate(delegate.getId()));
	}

	private void solveAddress(School school) {
		Address address = school.getAddress();
		if(address == null){
			throw new RuntimeException();
		}
		Address savedAddress = addressService.findByStreetName(address.getStreetName());
		if (savedAddress != null){
			address = addressService.update(savedAddress.getId(), address);
		}else {
			address = addressService.create(address);
		}
		school.setAddress(new Address(address.getId()));
	}

}
