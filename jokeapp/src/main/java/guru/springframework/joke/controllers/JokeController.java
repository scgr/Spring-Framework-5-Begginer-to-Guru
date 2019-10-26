package guru.springframework.joke.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.joke.services.JokeService;

@Controller
public class JokeController {

	@Autowired
	private JokeService jokeService;

	@RequestMapping({ "/", "" })
	public String showJoke(Model model) {
		model.addAttribute("joke", jokeService.getJoke());
		
		return "chucknorris";
	}

}
