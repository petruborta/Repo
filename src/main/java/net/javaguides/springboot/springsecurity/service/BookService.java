package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.springsecurity.model.Book;
import net.javaguides.springboot.springsecurity.repository.BookRepository;


@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public List<Book> listAll() {
		return repo.findAll();
	}
	
	public void save(Book book) {
		repo.save(book);
	}
	
	public Book get(long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

	public List<Book> getByUserEmail(String email) {
		return repo.getByUser_Email(email);
	}
}
