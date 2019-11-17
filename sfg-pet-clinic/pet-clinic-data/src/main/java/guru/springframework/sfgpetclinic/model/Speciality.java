package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

	@Column(name = "description")
	private String despcription;

	/**
	 * @return the despcription
	 */
	public String getDespcription() {
		return despcription;
	}

	/**
	 * @param despcription the despcription to set
	 */
	public void setDespcription(String despcription) {
		this.despcription = despcription;
	}

}
