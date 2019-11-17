package guru.springframework.services;

import java.util.HashSet;
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

	@Override
	public Set<Recipe> getRecipes() {
		log.debug("It's being processing the getRecipes method on RecipeService");
		
		Set<Recipe> recipes = new HashSet<>();

		recipeRepository.findAll().forEach(recipes::add);

		return recipes;
	}

}
