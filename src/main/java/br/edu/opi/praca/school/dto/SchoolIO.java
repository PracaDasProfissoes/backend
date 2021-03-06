package br.edu.opi.praca.school.dto;

import br.edu.opi.praca.delegate.model.Delegate;
import br.edu.opi.praca.places.model.Address;
import br.edu.opi.praca.places.model.City;
import br.edu.opi.praca.school.model.School;
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

/**
 * Mapper to User.
 */
@Component("schoolIO")
public class SchoolIO {

	private ModelMapper modelMapper;

	final Converter<SchoolInput, School> schoolInputConverter = new Converter<SchoolInput, School>() {
		@Override
		public School convert(MappingContext<SchoolInput, School> context) {
			SchoolInput input = context.getSource();
			return new School(
					input.getSchoolName(),
					new City(input.getSchoolCityCbo()),
					new Delegate(null, input.getDelegateEmail(), input.getDelegateName(), input.getPassword()),
					new Address(null, input.getStreetName(),input.getCep(),null , new City(input.getSchoolCityCbo())));
		}
	};

	final Converter<School, SchoolOutput> schoolOutputConverter = new Converter<School, SchoolOutput>() {
		@Override
		public SchoolOutput convert(MappingContext<School, SchoolOutput> context) {
			School input = context.getSource();
			return toSchoolOutput(input);
		}
	};

	final Converter<List<School>, List<SchoolOutput>> schoolOutputListConverter = new Converter<List<School>, List<SchoolOutput>>() {
		@Override
		public List<SchoolOutput> convert(MappingContext<List<School>, List<SchoolOutput>> context) {
			List<School> input = context.getSource();
			List<SchoolOutput> result = new LinkedList<>();
			for (School s : input) {
				result.add(toSchoolOutput(s));
			}
			return result;
		}
	};

	public SchoolIO() {
		this.modelMapper = new ModelMapper();
		this.modelMapper.addConverter(schoolInputConverter);
		this.modelMapper.addConverter(schoolOutputConverter);
		this.modelMapper.addConverter(schoolOutputListConverter);
	}

	public School mapTo(SchoolInput schoolInput) {
		return this.modelMapper.map(schoolInput, School.class);
	}

	public SchoolOutput mapTo(School school) {
		return this.modelMapper.map(school, SchoolOutput.class);
	}

	public List<SchoolOutput> toList(List<School> source) {
		Type dest = new TypeToken<List<SchoolOutput>>() {
		}.getType();
		return modelMapper.map(source, dest);
	}

	public Set<SchoolOutput> toSet(Set<School> source) {
		Type dest = new TypeToken<Set<SchoolOutput>>() {
		}.getType();
		return modelMapper.map(source, dest);
	}

	public Page<SchoolOutput> toPage(Page<School> source) {
		List<SchoolOutput> list = toList(source.getContent());
		return new PageImpl<>(list, source.getPageable(), source.getTotalElements());
	}

	private SchoolOutput toSchoolOutput(School school) {
		SchoolOutput schoolOutput = new SchoolOutput();
		schoolOutput.setId(school.getId());
		schoolOutput.setSchoolName(school.getName());
		schoolOutput.setSchoolCityCbo(school.getCity() != null ? school.getCity().getCboCode() : null);
		if (school.getDelegate() != null) {
			Delegate delegate = school.getDelegate();
			schoolOutput.setDelegateEmail(delegate.getUsername());
			schoolOutput.setDelegateName(delegate.getName());
			schoolOutput.setDelegatePhone(delegate.getPhone());
		}
		schoolOutput.setEnabled(school.isEnabled());
		schoolOutput.setCep(school.getAddress().getCep());
		schoolOutput.setCnpj(school.getCnpj());
		schoolOutput.setSigla(school.getSigla());
		return schoolOutput;
	}

}
