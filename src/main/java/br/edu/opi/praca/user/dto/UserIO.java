package br.edu.opi.praca.user.dto;

import br.edu.opi.praca.project_patterns.models.user.Profile;
import br.edu.opi.praca.user.model.UserFactory;
import br.edu.opi.praca.user.model.UserModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Mapper to User.
 */
@Component("userIO")
public class UserIO {

	private ModelMapper modelMapper;

	final Converter<UserInput, UserModel> userConverter = new Converter<UserInput, UserModel>() {

		@Override
		public UserModel convert(MappingContext<UserInput, UserModel> context) {
			UserInput userInput = context.getSource();
			// @formatter:off
			return UserFactory.createUserObject(
					userInput.getEmail(),
					userInput.getPassword(),
					userInput.getName(),
					userInput.getCpf(),
					new Profile(userInput.getProfileId()));
			// @formatter:on
		}
	};

	public UserIO() {
		modelMapper = new ModelMapper();
		modelMapper.addConverter(userConverter);
	}

	public UserModel mapTo(UserInput userInput) {
		return this.modelMapper.map(userInput, UserModel.class);
	}

}
