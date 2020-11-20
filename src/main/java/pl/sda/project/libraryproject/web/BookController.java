package pl.sda.project.libraryproject.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.project.libraryproject.domain.book.Book;
import pl.sda.project.libraryproject.domain.book.BookService;

import javax.validation.Valid;
import java.util.Optional;


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
        ModelAndView mav = new ModelAndView("addBook.html");
        mav.addObject("book", new Book());
        return mav;

    }


    @GetMapping("/edit/{id}")
    ModelAndView displayEditBookPage(@PathVariable Long id ) {
        Optional<Book> book = bookService.getBookById(id);
        ModelAndView mav = new ModelAndView();
        if (book.isPresent()){
            mav.addObject("book",book.get());
            mav.setViewName("addBook.html");

        }else{
            mav.addObject("message",String.format("Książka z id %d nie istnieje", id));
            mav.setViewName("error.html");
        }

        return mav;

    }
    @PostMapping("/addOrEdit")
    String handleAddBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addBook.html";
        }

        if (book.getId() != null) {
            bookService.update(book);
        } else {
            bookService.create(book);
        }
        return "redirect:/mvc/book";


    }

    @GetMapping("/delete/{id}")
    String handleDeleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/mvc/book";
    }

}
