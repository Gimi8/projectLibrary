package pl.sda.project.libraryproject.domain.user;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User > findOne(Long id);
    Optional<User> findByUsername(String username);
    List<User > findAll();
    void create (User user);
    void update(User user);
    void delete(Long id);
}
