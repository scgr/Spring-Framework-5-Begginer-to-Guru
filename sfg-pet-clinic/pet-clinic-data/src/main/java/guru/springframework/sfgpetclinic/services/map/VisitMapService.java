package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit entity) {
		if (entity == null || entity.getPet() == null || entity.getPet().getOwner() == null
				|| entity.getPet().getId() == null || entity.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid visit");
		}

		return super.save(entity);
	}

	@Override
	public void delete(Visit entity) {
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
