package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component // Anotacion que representa un Bean en Spring
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	/**
	 * @param authorRepository
	 * @param bookRepository
	 */
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	/**
	 * Method to initialize the H2 database data
	 */
	private void initData() {
		// Eric
		Author eric = new Author("Eric", "Evans");
		Book b1 = new Book("Domain Driven Design", "01234", "Harper Collins");
		eric.getBooks().add(b1);
		b1.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(b1);

		// Rod
		Author rod = new Author("Rod", "Johnson");
		Book b2 = new Book("J2EE Development without EJB", "56789", "Worx");
		rod.getBooks().add(b2);

		authorRepository.save(rod);
		bookRepository.save(b2);
	}

}
