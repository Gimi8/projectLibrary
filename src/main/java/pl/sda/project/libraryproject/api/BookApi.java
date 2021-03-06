package pl.sda.project.libraryproject.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.project.libraryproject.domain.book.Book;
import pl.sda.project.libraryproject.domain.book.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookApi {
    private BookService bookService;


    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getOne(@PathVariable Long bookId) {
        return bookService.getBookById(bookId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createBook(@RequestBody @Valid Book book, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errors);
        }

        bookService.create(book);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@RequestParam Long bookId) {
        bookService.delete(bookId);
    }










}
