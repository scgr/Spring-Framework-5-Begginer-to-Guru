package guru.springframework.joke.services;

import org.springframework.beans.factory.annotation.Autowired;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

//@Service
public class JokeServiceImpl implements JokeService {

	@Autowired
	private ChuckNorrisQuotes chuckNorrisQuotes;

	@Override
	public String getJoke() {
		return chuckNorrisQuotes.getRandomQuote();
	}

}
