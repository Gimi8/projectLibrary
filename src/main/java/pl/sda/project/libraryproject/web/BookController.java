package pl.sda.project.libraryproject.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.project.libraryproject.domain.book.BookService;

import java.awt.print.Book;

@Controller
@RequestMapping("mvc/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping
    ModelAndView displayBookPage() {
        ModelAndView mav = new ModelAndView("books.html");
        mav.addObject("books", bookService.getAll());
        return mav;
    }

    @GetMapping("/add")
    ModelAndView displayAddBookPage() {
        ModelAndView mav = new ModelAndView("addBook");
        mav.addObject("book", new Book());
        return mav;

    }

    @PostMapping("/add")
    String handleAddBook(@ModelAttribute("book") Book book) {
        bookService.create(book);


    }

}
