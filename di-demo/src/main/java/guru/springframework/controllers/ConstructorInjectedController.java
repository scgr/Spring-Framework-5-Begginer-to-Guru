package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import guru.springframework.services.GreetingService;

@Controller // Anotacion para indicar que es un controlador y que se genere un bean para
			// tratarlo
public class ConstructorInjectedController {

	private GreetingService greetingService;

	/**
	 * @param greetingService
	 */
	@Autowired // Anotacion para enlazar un bean durante el uso de esta clase.
	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayHello() {
		return greetingService.sayGreeting();
	}

}
