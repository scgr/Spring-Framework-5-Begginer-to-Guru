package guru.springframework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary // Anotacion usada para cuando se encuentran varios servicios posibles, este es el primario
@Profile("es")
public class PrimarySpanishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello - Primary greeting service in Spanish!!!";
	}

}
