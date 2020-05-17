package net.javaguides.springboot.springsecurity.model;

import javax.persistence.*;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column
	private String isbn;

	@Column
	private String author;

	@Column
	private Float price;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	protected Book() {
	}

	protected Book(Long id, String title, String isbn, String author, float price, User user) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.user = user;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
