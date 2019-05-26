package br.edu.opi.praca.places.repository;

import br.edu.opi.praca.places.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByStreetName(String streetName);
}
