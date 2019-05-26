package br.edu.opi.praca.educational_agent.dto;


import br.edu.opi.praca.educational_agent.models.EducationalAgent;
import br.edu.opi.praca.person.models.Person;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class EducationalAgentIO {

    private ModelMapper modelMapper;

    final Converter<EducationalAgentInput, EducationalAgent> educationalAgentConverter = new Converter<EducationalAgentInput, EducationalAgent>() {
        @Override
        public EducationalAgent convert(MappingContext<EducationalAgentInput, EducationalAgent> mappingContext) {

            return null;
        }
    };

    final Converter<EducationalAgent, EducationalAgentOutput> educationalAgentOutputConverter = new Converter<EducationalAgent, EducationalAgentOutput>() {
        @Override
        public EducationalAgentOutput convert(MappingContext<EducationalAgent, EducationalAgentOutput> mappingContext) {
            return null;
        }
    };

    final Converter<List<EducationalAgent>, List<EducationalAgentOutput>> educationalAgentOutputListConverter = new Converter<List<EducationalAgent>, List<EducationalAgentOutput>>() {
        @Override
        public List<EducationalAgentOutput> convert(MappingContext<List<EducationalAgent>, List<EducationalAgentOutput>> context) {
            List<EducationalAgent> input = context.getSource();
            List<EducationalAgentOutput> result = new LinkedList<>();
            for (EducationalAgent s : input) {
                result.add(toEducationalAgentOutput(s));
            }
            return result;
        }
    };

    public EducationalAgentIO() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(educationalAgentConverter);
        this.modelMapper.addConverter(educationalAgentOutputConverter);
        this.modelMapper.addConverter(educationalAgentOutputListConverter);
    }

    public EducationalAgent mapTo(EducationalAgentInput EducationalAgentInput) {
        return this.modelMapper.map(EducationalAgentInput, EducationalAgent.class);
    }

    public EducationalAgentOutput mapTo(EducationalAgent school) {
        return this.modelMapper.map(school, EducationalAgentOutput.class);
    }

    public List<EducationalAgentOutput> toList(List<EducationalAgent> source) {
        Type dest = new TypeToken<List<EducationalAgentOutput>>() {
        }.getType();
        return modelMapper.map(source, dest);
    }

    public Set<EducationalAgentOutput> toSet(Set<EducationalAgent> source) {
        Type dest = new TypeToken<Set<EducationalAgentOutput>>() {
        }.getType();
        return modelMapper.map(source, dest);
    }

    public Page<EducationalAgentOutput> toPage(Page<EducationalAgent> source) {
        List<EducationalAgentOutput> list = toList(source.getContent());
        return new PageImpl<>(list, source.getPageable(), source.getTotalElements());
    }

    private EducationalAgentOutput toEducationalAgentOutput(EducationalAgent educationalAgent) {
        EducationalAgentOutput educationalAgentOutput = new EducationalAgentOutput();
        educationalAgentOutput.setId(educationalAgent.getId());
        educationalAgentOutput.setCityCbo(educationalAgent.getAddress().getUf() != null ? educationalAgent.getAddress().getUf().getCboCode() : null);
        if (educationalAgent.getPerson() != null) {
            Person person= educationalAgent.getPerson();
            //educationalAgentOutput.setDelegateEmail(delegate.getUsername());
           // educationalAgentOutput.setDelegateName(delegate.getName());
            //educationalAgentOutput.setDelegatePhone(delegate.getPhone());
        }
        educationalAgentOutput.setCep(educationalAgent.getAddress().getCep());
        educationalAgentOutput.setCpf(educationalAgent.getCpf());
        return educationalAgentOutput;
    }
}
