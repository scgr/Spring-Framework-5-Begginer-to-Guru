package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

	private Set<Speciality> specialites = new HashSet<Speciality>();

	/**
	 * @return the specialites
	 */
	public Set<Speciality> getSpecialites() {
		return specialites;
	}

	/**
	 * @param specialites the specialites to set
	 */
	public void setSpecialites(Set<Speciality> specialites) {
		this.specialites = specialites;
	}

}
