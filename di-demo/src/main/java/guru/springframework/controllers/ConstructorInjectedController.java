package guru.springframework.controllers;

import guru.springframework.services.GreetingService;

public class ConstructorInjectedController {

	private GreetingService greetingService;

	/**
	 * @param greetingService
	 */
	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	String sayHello() {
		return greetingService.sayGreeting();
	}

}
