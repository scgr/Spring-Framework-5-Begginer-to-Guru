package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity //Anotacion de entidad para relacionarlo con una tabla de base de datos
public class Author {

	@Id //Anotacion de identificador unico de tabla en la base de datos (PK)
	@GeneratedValue(strategy = GenerationType.AUTO) //Anotacion de valor generado automaticamente
	private Long id;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors") //Anotacion para indicar que la relacion es muchos a muchos respecto a Book
	private Set<Book> books = new HashSet<>();

	/**
	 * Default constructor
	 */
	public Author() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public Author(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param books
	 */
	public Author(String firstName, String lastName, Set<Book> books) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
