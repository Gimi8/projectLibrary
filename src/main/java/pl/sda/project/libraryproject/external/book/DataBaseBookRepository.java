package pl.sda.project.libraryproject.external.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.project.libraryproject.domain.book.Book;
import pl.sda.project.libraryproject.domain.book.BookRepository;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DataBaseBookRepository implements BookRepository {

    private JpaBookRepository jpaBookRepository;


    @Override
    public Optional<Book> findOne(Long id) {
        return jpaBookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public void create(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Long id) {

    }
}
