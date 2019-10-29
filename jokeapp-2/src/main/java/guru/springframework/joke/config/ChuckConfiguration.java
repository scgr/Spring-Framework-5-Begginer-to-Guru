package guru.springframework.joke.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Configuration // Anotacion para hacer que la clase se encargue de declarar los beans que van a
				// ser utilizados en el proyecto.
public class ChuckConfiguration {

	@Bean // Anotacion para indicar que este objeto va a ser un bean usado dentro de la aplicacion.
	public ChuckNorrisQuotes chuckNorrisQuotes() {
		return new ChuckNorrisQuotes();
	}

}
