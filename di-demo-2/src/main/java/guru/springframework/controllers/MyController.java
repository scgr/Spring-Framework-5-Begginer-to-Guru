package guru.springframework.controllers;

import org.springframework.stereotype.Controller;

import guru.services.GreetingService;

@Controller
public class MyController {

	private GreetingService greetingService;

	/**
	 * @param greetingService
	 */
	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String hello() {
		// System.out.println("Hello!!!");

		return greetingService.sayGreeting();
	}

}
