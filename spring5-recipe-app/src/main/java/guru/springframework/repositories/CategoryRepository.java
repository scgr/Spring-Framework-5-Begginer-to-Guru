package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	public Optional<Category> findByDescription(String description);

}
