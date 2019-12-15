package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({ "recipe/show/{id}" })
	public String showById(@PathVariable String id, Model model) {
		log.debug("It's being processing the showRecipe method on RecipeController");

		model.addAttribute("recipe", recipeService.findById(new Long(id)));

		return "recipe/show";
	}
}
