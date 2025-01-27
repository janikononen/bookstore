package fi.haagahelia.kononenbookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.kononenbookstore.domain.Book;
import fi.haagahelia.kononenbookstore.domain.BookRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/booklist")
    public String listOfBooks(Model model) {
        model.addAttribute("book", repository.findAll());
        return "booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/save")
    public String save(Book book) {

        repository.save(book);
        return "redirect.booklist";
    }

}
