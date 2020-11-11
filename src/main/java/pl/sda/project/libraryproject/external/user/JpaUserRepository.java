package pl.sda.project.libraryproject.external.user;

import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.project.libraryproject.domain.user.User;
import pl.sda.project.libraryproject.external.book.BookEntity;

import java.util.Optional;

@Repository
public interface JpaUserRepository  extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity>findById(Long id);
    Optional<UserEntity>findByFirstnameAndLastname(String firstname , String lastname);



}
