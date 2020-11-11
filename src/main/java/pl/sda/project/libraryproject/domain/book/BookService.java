package pl.sda.project.libraryproject.domain.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public void create(Book book) {
        bookRepository.create(book);
    }


    public void update(Book book) {
        bookRepository.update(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findOne(id);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void delete(Long id) {
        bookRepository.delete(id);
    }

}
