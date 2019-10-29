package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.services.GreetingService;

@Controller // Anotacion para indicar que es un controlador y que se genere un bean para
			// tratarlo
public class PropertyInjectedController {

	@Autowired // Anotacion para enlazar un bean durante el uso de esta clase.
	@Qualifier("greetingServiceImpl") // Anotacion para identificar qué servicio es inyectado
	public GreetingService greetingService;

	public String sayHello() {
		return greetingService.sayGreeting();
	}

}
