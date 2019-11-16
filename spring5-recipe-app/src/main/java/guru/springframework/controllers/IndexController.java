package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UnitOfMeasureRepository unitOfMeasureRepository;

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {

		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

		System.out.println("Category Id: " + categoryOptional.get().getId());
		System.out.println("Unit of measure Id: " + unitOfMeasureOptional.get().getId());

		return "index";
	}

}
