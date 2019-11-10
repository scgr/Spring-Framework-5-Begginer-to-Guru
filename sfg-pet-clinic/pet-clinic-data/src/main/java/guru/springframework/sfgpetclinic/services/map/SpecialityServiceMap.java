package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialitesService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitesService {

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality entity) {
		return super.save(entity);
	}

	@Override
	public void delete(Speciality entity) {
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
