package pl.sda.project.libraryproject.external.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.project.libraryproject.domain.book.Book;
import pl.sda.project.libraryproject.domain.book.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DataBaseBookRepository implements BookRepository {

    private JpaBookRepository jpaBookRepository;


    @Override
    public Optional<Book> findOne(Long id) {
        return jpaBookRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return jpaBookRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void create(Book book) {
        jpaBookRepository.save(toEntity(book));
    }


    @Override
    public void update(Book book) {
        if (!jpaBookRepository.existsById(book.getId())) {
            throw new IllegalStateException("Updated object not exist");
        }
        jpaBookRepository.save(toEntity(book));

    }

    @Override
    public void delete(Long id) {
        jpaBookRepository.deleteById(id);
    }




    private Book toDomain(BookEntity entity) {
        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .quantity(entity.getQuantity())
                .build();
    }

    private BookEntity toEntity(Book book) {
        return BookEntity.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .quantity(book.getQuantity())
                .build();

    }
}
