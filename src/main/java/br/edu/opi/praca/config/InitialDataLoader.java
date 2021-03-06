package br.edu.opi.praca.config;

import br.edu.opi.praca.project_patterns.models.user.Privilege;
import br.edu.opi.praca.project_patterns.models.user.Profile;
import br.edu.opi.praca.project_patterns.models.user.ProfileFactory;
import br.edu.opi.praca.project_patterns.repository.ProfileRepository;
import br.edu.opi.praca.user.model.UserFactory;
import br.edu.opi.praca.user.model.UserModel;
import br.edu.opi.praca.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup;
	private UserRepository userRepository;
	private ProfileRepository profileRepository;

	@Autowired
	public InitialDataLoader(
			UserRepository userRepository,
			ProfileRepository profileRepository) {
		this.userRepository = userRepository;
		this.profileRepository = profileRepository;
		this.alreadySetup = false;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}

		// Profile Delegate
		createProfileIfNotFound(ProfileFactory.delegateUser());

		// Profile Admin
		final Profile profile_admin = createProfileIfNotFound("Administrador", new HashSet<Privilege>() {
			private static final long serialVersionUID = -4532748588777883116L;

			{
				addAll(Arrays.asList(Privilege.values()));
			}
		});

		// Profile Test
		final Profile profile_teste = createProfileIfNotFound("Usuário Padrão", new HashSet<Privilege>() {
			private static final long serialVersionUID = -4532748588777883116L;

			{
				add(Privilege.C_US);
				add(Privilege.S_US);
				add(Privilege.I_US);
				add(Privilege.U_US);
			}
		});

		// User Admin
		UserModel user = UserFactory.createUserObject("administrador@email.com", "P@ssw0rd", "Administrador", "111.111.111-11", profile_admin);
		user.setNeedChangePassword(false);
		user = createUserIfNotFound(user);

		// User Test
		UserModel userTest = UserFactory.createUserObject("test@email.com", "P@ssw0rd", "Test", "986.863.610-80", profile_teste);
		userTest.setNeedChangePassword(true);
		userTest = createUserIfNotFound(userTest);

	}

	private Profile createProfileIfNotFound(final String name, final Collection<Privilege> privileges) {
		Profile profile = profileRepository.findByName(name);
		if (profile == null) {
			profile = new Profile(name, new HashSet<>(privileges));
			profile = profileRepository.save(profile);
		}
		return profile;
	}

	private Profile createProfileIfNotFound(Profile profile) {
		return createProfileIfNotFound(profile.getName(), profile.getPrivileges());
	}

	private UserModel createUserIfNotFound(final UserModel userModel) {
		UserModel savedUser = userRepository.findByUsername(userModel.getUsername());
		if (savedUser == null) {
			savedUser = userRepository.save(userModel);
		}
		return savedUser;
	}

}