package br.edu.opi.praca.school.repository;

import br.edu.opi.praca.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

	School findByDelegateUsername(String username);

}
