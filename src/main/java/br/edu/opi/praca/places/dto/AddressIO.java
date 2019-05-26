package br.edu.opi.praca.places.dto;

import br.edu.opi.praca.places.model.Address;
import br.edu.opi.praca.places.model.City;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AddressIO {

    private ModelMapper modelMapper;

    final Converter<AddressInput, Address> inputAddressConverter = new Converter<AddressInput,Address>()  {
        @Override
        public Address convert(MappingContext<AddressInput, Address> context) {
            AddressInput input = context.getSource();

            return new Address(null, input.getStreetName(), input.getCep(),
                    input.getBuildingNumber(),
                    new City(input.getSchoolCityCbo()));

        }
    };

    final Converter<Address, AddressOutput> AddressOutputConverter = new Converter<Address, AddressOutput>() {
        @Override
        public AddressOutput convert(MappingContext<Address, AddressOutput> context) {
            Address input = context.getSource();
            return toAddressOutput(input);
        }
    };

    final Converter<List<Address>, List<AddressOutput>> AddressOutputListConverter = new Converter<List<Address>, List<AddressOutput>>() {
        @Override
        public List<AddressOutput> convert(MappingContext<List<Address>, List<AddressOutput>> context) {
            List<Address> input = context.getSource();
            List<AddressOutput> result = new LinkedList<>();
            for (Address s : input) {
                result.add(toAddressOutput(s));
            }
            return result;
        }
    };

    public AddressIO() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(inputAddressConverter);
        this.modelMapper.addConverter(AddressOutputConverter);
        this.modelMapper.addConverter(AddressOutputListConverter);
    }

    public Address mapTo(AddressInput AddressInput) {
        return this.modelMapper.map(AddressInput, Address.class);
    }

    public AddressOutput mapTo(Address school) {
        return this.modelMapper.map(school, AddressOutput.class);
    }

    public List<AddressOutput> toList(List<Address> source) {
        Type dest = new TypeToken<List<AddressOutput>>() {
        }.getType();
        return modelMapper.map(source, dest);
    }

    public Set<AddressOutput> toSet(Set<Address> source) {
        Type dest = new TypeToken<Set<AddressOutput>>() {
        }.getType();
        return modelMapper.map(source, dest);
    }

    public Page<AddressOutput> toPage(Page<Address> source) {
        List<AddressOutput> list = toList(source.getContent());
        return new PageImpl<>(list, source.getPageable(), source.getTotalElements());
    }

    private AddressOutput toAddressOutput(Address address) {
        AddressOutput addressOutput = new AddressOutput();
        addressOutput.setId(address.getId());
        addressOutput.setBuildingNumber(address.getBuildingNumber());
        addressOutput.setStreetName(address.getStreetName());
        addressOutput.setCep(address.getCep());

        return addressOutput;
    }

}
