package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.CrudService;

public class OwnerServiceMap implements CrudService<Owner, Long> {

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner entity) {
		return super.save(entity.getId(), entity);
	}

	@Override
	public void delete(Owner entity) {
		super.delete();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
}
