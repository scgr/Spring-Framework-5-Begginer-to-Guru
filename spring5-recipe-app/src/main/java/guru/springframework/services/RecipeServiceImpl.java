package guru.springframework.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		log.debug("It's being processing the getRecipes method on RecipeService");

		Set<Recipe> recipes = new HashSet<>();

		recipeRepository.findAll().forEach(recipes::add);

		return recipes;
	}

	@Override
	public Recipe findById(Long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
		
		if(!recipe.isPresent()){
			throw new RuntimeException("Recipe not found!!!");
		}
		
		return recipe.get();
	}

}
