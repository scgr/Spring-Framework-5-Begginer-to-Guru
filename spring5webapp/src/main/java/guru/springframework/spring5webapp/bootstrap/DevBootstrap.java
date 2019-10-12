package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component // Anotacion que representa un Bean en Spring
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	/**
	 * @param authorRepository
	 * @param bookRepository
	 */
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	/**
	 * Method to initialize the H2 database data
	 */
	private void initData() {
		
		// Publisher
		Publisher publisher = new Publisher();
		publisher.setName("Publisher 1");
		
		publisherRepository.save(publisher);
		
		// Eric
		Author eric = new Author("Eric", "Evans");
		Book b1 = new Book("Domain Driven Design", "01234", publisher);
		eric.getBooks().add(b1);
		b1.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(b1);

		// Rod
		Author rod = new Author("Rod", "Johnson");
		Book b2 = new Book("J2EE Development without EJB", "56789", publisher);
		rod.getBooks().add(b2);

		authorRepository.save(rod);
		bookRepository.save(b2);
	}

}
