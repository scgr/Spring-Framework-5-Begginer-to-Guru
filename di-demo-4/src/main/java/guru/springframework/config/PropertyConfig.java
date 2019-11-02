package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource({ "classpath:datasource.properties", "classpath:jms.properties" }) // Anotacion para indicar cuales son
// los fichero de propiedades del que va a matchear los valores

//@PropertySources({ @PropertySource("classpath:datasource.properties"), @PropertySource("classpath:jms.properties") })
public class PropertyConfig {

	@Autowired
	Environment environment;

	@Value("${guru.name}") // Anotacion para matchear una propiedad de un fichero con un atributo java
	String name;

	@Value("${guru.password}")
	String password;

	@Value("${guru.dburl}")
	String url;

	@Value("${guru.jms.name}")
	String jmsname;

	@Value("${guru.jms.password}")
	String jmspassword;

	@Value("${guru.jms.topicurl}")
	String topicurl;

	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		// fakeDataSource.setName(environment.getProperty("USERNAME")); This load the
		// property from environment variable
		fakeDataSource.setName(name);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);

		return fakeDataSource;
	}

	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setName(jmsname);
		fakeJmsBroker.setPassword(jmspassword);
		fakeJmsBroker.setUrl(topicurl);

		return fakeJmsBroker;
	}

	// Bean usado para leer ficheros de propiedades especificos (excepto el de
	// application.properties de Spring Boot).
	/*
	 * @Bean public static PropertySourcesPlaceholderConfigurer properties() {
	 * return new PropertySourcesPlaceholderConfigurer(); }
	 */

}
