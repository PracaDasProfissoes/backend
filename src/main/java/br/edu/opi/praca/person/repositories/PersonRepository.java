package br.edu.opi.praca.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.opi.praca.person.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
