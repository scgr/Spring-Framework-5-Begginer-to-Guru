package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import guru.springframework.services.GreetingService;

@Controller // Anotacion para indicar que es un controlador y que se genere un bean para
			// tratarlo
public class PropertyInjectedController {

	@Autowired // Anotacion para enlazar un bean durante el uso de esta clase.
	public GreetingService greetingService;

	public String sayHello() {
		return greetingService.sayGreeting();
	}

}
