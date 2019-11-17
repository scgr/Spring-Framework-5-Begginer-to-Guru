package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialitesService;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialitesService {

	private final SpecialityRepository specialityRepository;

	/**
	 * @param specialityRepository
	 */
	public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();

		specialityRepository.findAll().forEach(specialities::add);

		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality entity) {
		return specialityRepository.save(entity);
	}

	@Override
	public void delete(Speciality entity) {
		specialityRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

}
