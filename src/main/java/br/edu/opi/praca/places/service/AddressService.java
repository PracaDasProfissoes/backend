package br.edu.opi.praca.places.service;

import br.edu.opi.praca.places.model.Address;
import br.edu.opi.praca.places.repository.AddressRepository;
import br.edu.opi.praca.project_patterns.services.GenericService;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends GenericService<Long, Address, AddressRepository> {

    @Override
    public void validateBeforeCreate(Address model) {

    }

    @Override
    public void validateBeforeUpdate(Address model) {

    }

    @Override
    public void validateBeforeDelete(Long aLong) {

    }

    public Address findByStreetName(String streetName) {
       return repository.findByStreetName(streetName);
    }
}
