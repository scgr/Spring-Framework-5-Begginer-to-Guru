package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity // Anotacion de entidad para relacionarlo con una tabla de base de datos
public class Book {

	@Id // Anotacion de identificador unico de tabla en la base de datos (PK)
	@GeneratedValue(strategy = GenerationType.AUTO) // Anotacion de valor generado automaticamente
	private Long id;
	private String title;
	private String isbn;
	private String publisher;

	@ManyToMany // Anotacion para indicar que la relacion es muchos a muchos respecto a Author
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	// Anotacion para indicar cual es el nombre de la tabla relacion y sus columnas
	// identificadoras
	private Set<Author> authors = new HashSet<>();

	/**
	 * Default constructor
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param isbn
	 * @param publisher
	 */
	public Book(String title, String isbn, String publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}

	/**
	 * @param title
	 * @param isbn
	 * @param publisher
	 * @param authors
	 */
	public Book(String title, String isbn, String publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}
