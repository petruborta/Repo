package net.javaguides.springboot.springsecurity.web;

import net.javaguides.springboot.springsecurity.model.Book;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.springsecurity.service.BookService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BookController {
	
	private final BookService bookService;
	private final UserService userService;

    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @RequestMapping("addbook")
    public String browseNewBookPage(@ModelAttribute("book") Book book) {
        return "new_book";
    }

    @RequestMapping("addbook/save")
    public String saveNewBook(@ModelAttribute("book") Book book) {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            String principalName = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByEmail(principalName);
            book.setUser(user);
            bookService.save(book);

            return "redirect:/index";
        } else {
            return "login";
        }
    }

    @RequestMapping
    public String getBooks(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            List<Book> listBooks = bookService.getByUserEmail(
                    SecurityContextHolder.getContext().getAuthentication().getName()
            );
            model.addAttribute("listBooks", listBooks);

            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping("updateBook")
    public String updateBook(@ModelAttribute("book") Book book) {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            String principalName = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByEmail(principalName);
            book.setUser(user);
            bookService.save(book);
            return "redirect:/index";
        } else {
            return "login";
        }
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Book book = bookService.get(id);
        mav.addObject("book", book);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") int id) {
        bookService.delete(id);
        return "redirect:/index";
    }
}
