package br.edu.opi.praca.educational_agent.repository;

import br.edu.opi.praca.educational_agent.models.EducationalAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalAgentRepository extends JpaRepository<EducationalAgent, Long> {
}
