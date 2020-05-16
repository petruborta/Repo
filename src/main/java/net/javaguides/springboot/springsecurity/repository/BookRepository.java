package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.springboot.springsecurity.model.Book;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getByUser_Email(String email);
}
