package pl.sda.project.libraryproject.external.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface JpaUserRepository  extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity>findById(Long id);
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity>findByFirstnameAndLastname(String firstname , String lastname);



}
