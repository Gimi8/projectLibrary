package pl.sda.project.libraryproject.external.book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sun.tools.javac.util.List;
import pl.sda.project.libraryproject.external.user.UserEntity;

import java.awt.*;
import java.util.Optional;

@Repository
public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findById(Long id);

    List<BookEntity> findByAuthor(String author);


}
