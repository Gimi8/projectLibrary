package pl.sda.project.libraryproject.domain.book;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findOne(Long id);


    List<Book> findAll();

    void create(Book book);
    void update(Book book);

    void delete(Long id);

}
