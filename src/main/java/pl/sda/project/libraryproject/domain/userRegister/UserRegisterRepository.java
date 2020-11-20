package pl.sda.project.libraryproject.domain.userRegister;

import java.util.Optional;

public interface UserRegisterRepository {
    void create(UserRegister userRegister);

    Optional<UserRegister> findByUsername(String username);
}
