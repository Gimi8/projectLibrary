package pl.sda.project.libraryproject.external.book;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findById(Long id);

    List<BookEntity> findByAuthor(String author);


}
