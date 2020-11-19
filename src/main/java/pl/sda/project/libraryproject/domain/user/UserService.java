package pl.sda.project.libraryproject.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {


    private UserRepository userRepository;

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }


    public void delete(Long id) {
        userRepository.delete(id);
    }


}
