package guru.springframework.sfgpetclinic.model;

public class Speciality extends BaseEntity {

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
