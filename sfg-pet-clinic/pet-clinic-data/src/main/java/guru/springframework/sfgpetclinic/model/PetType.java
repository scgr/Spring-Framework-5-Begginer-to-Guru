package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "petTypes")
public class PetType extends BaseEntity {

	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}

	@Column(name = "name")
	private String name;

}
