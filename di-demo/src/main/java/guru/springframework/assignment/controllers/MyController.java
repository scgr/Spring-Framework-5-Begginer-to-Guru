package guru.springframework.assignment.controllers;

import guru.springframework.assignment.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 5/23/17.
 */
@Controller
public class MyController {

	private GreetingService greetingService;

	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String hello() {
		System.out.println("Hello!!! ");

		return greetingService.sayGreeting();
	}
}
