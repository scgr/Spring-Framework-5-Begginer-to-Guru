package guru.springframework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // Anotacion usada para cuando se encuentran varios servicios posibles, este es el primario
public class PrimaryGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello - Primary greeting service";
	}

}
