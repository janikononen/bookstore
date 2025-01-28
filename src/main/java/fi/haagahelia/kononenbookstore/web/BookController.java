package fi.haagahelia.kononenbookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import fi.haagahelia.kononenbookstore.domain.Book;
import fi.haagahelia.kononenbookstore.domain.BookRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/booklist")
    public String listOfBooks(Model model) {
        model.addAttribute("books", repository.findAll());
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
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Väärä bookId " + bookId));
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book åasla) {
        repository.save(åasla);
        return "redirect:/booklist";
    }

}
