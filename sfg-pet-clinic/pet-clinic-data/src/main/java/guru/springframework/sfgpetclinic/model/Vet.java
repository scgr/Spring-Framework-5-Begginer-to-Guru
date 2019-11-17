package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
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
