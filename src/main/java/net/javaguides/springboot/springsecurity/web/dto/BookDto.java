package net.javaguides.springboot.springsecurity.web.dto;

import net.javaguides.springboot.springsecurity.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDto {

    private String title;
    private String isbn;
    private String author;
    private float price;

    public static List<BookDto> toDtos(List<Book> books) {
        return books.stream().map(BookDto::toDto).collect(Collectors.toList());
    }

    public static BookDto toDto(Book book) {
        return new BookDto(
        		book.getTitle(),
        		book.getIsbn(),
        		book.getAuthor(),
        		book.getPrice()
        );
    }

    public BookDto(String title, String isbn, String author, float price) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
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

	public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
