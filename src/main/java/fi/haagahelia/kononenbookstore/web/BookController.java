package fi.haagahelia.kononenbookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import fi.haagahelia.kononenbookstore.domain.Book;
import fi.haagahelia.kononenbookstore.domain.BookRepository;
import fi.haagahelia.kononenbookstore.domain.CategoryRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bRepository;
    private final CategoryRepository cRepository;

    public BookController(BookRepository bRepository, CategoryRepository cRepository) {
        this.bRepository = bRepository;
        this.cRepository = cRepository;
    }

    @GetMapping("/booklist")
    public String listOfBooks(Model model) {
        model.addAttribute("books", bRepository.findAll());
        return "booklist";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/books")
    @ResponseBody
    public List<Book> books() {
        return (List<Book>) bRepository.findAll();
    }

    @GetMapping("/book/{id}")
    @ResponseBody
    public Optional<Book> getBookById(@PathVariable("id") Long id) {
        return bRepository.findById(id);
    }

    // add new book
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addBook";
    }

    @PostMapping("/save")
    public String save(Book book) {

        bRepository.save(book);
        return "redirect:/booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        bRepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = bRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Väärä bookId " + bookId));
        model.addAttribute("book", book);
        model.addAttribute("categories", cRepository.findAll());
        return "editBook";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book) {
        bRepository.save(book);
        return "redirect:/booklist";
    }

}
