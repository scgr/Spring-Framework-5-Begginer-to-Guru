package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

	private final VetRepository vetRepository;

	/**
	 * @param vetRepository
	 */
	public VetSDJpaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();

		vetRepository.findAll().forEach(vets::add);

		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet entity) {
		return vetRepository.save(entity);
	}

	@Override
	public void delete(Vet entity) {
		vetRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
