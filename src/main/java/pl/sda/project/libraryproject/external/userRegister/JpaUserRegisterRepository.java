package pl.sda.project.libraryproject.external.userRegister;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRegisterRepository  extends JpaRepository<UserRegisterEntity , Long> {

    Optional<UserRegisterEntity>findByUsername(String username);


}
