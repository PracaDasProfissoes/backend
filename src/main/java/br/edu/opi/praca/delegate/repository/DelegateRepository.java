package br.edu.opi.praca.delegate.repository;

import br.edu.opi.praca.delegate.model.Delegate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelegateRepository extends JpaRepository<Delegate, Long>{

	Delegate findByUsername(String username);

}
