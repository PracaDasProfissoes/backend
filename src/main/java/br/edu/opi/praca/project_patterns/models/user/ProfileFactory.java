package br.edu.opi.praca.project_patterns.models.user;

import java.util.HashSet;
import java.util.Set;

public class ProfileFactory {

	public static Profile delegateUser() {
		Set<Privilege> delegatePrivileges = new HashSet<Privilege>() {
			private static final long serialVersionUID = 2249152407872739555L;

			{
				// TODO: change to Delegate own privileges
				add(Privilege.S_US);
				add(Privilege.U_US);
			}
		};
		return new Profile(1L, "Delegado", delegatePrivileges);
	}

}
