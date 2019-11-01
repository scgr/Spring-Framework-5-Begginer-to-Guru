package guru.springframework.services;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepositoryImpl implements GreetingRepository {

	@Override
	public String getEnglishGreeting() {
		return "Hello - Primary greeting service";
	}

	@Override
	public String getSpanishGreeting() {
		return "Hello - Primary greeting service in German (Primärer Begrüßungsdienst)!!!";
	}

	@Override
	public String getGermanGreeting() {
		return "Hello - Primary greeting service in Spanish!!!";
	}

}
