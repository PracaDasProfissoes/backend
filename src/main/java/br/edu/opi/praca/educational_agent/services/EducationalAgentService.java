package br.edu.opi.praca.educational_agent.services;

import br.edu.opi.praca.educational_agent.models.EducationalAgent;
import br.edu.opi.praca.educational_agent.repository.EducationalAgentRepository;
import br.edu.opi.praca.project_patterns.services.GenericService;
import org.springframework.stereotype.Service;

@Service
public class EducationalAgentService  extends GenericService<Long, EducationalAgent, EducationalAgentRepository> {
    @Override
    public void validateBeforeCreate(EducationalAgent model) {

    }

    @Override
    public void validateBeforeUpdate(EducationalAgent model) {

    }

    @Override
    public void validateBeforeDelete(Long aLong) {

    }
}
