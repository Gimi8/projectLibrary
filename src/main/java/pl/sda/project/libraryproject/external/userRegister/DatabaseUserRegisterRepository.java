package pl.sda.project.libraryproject.external.userRegister;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import pl.sda.project.libraryproject.domain.userRegister.UserRegister;
import pl.sda.project.libraryproject.domain.userRegister.UserRegisterRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DatabaseUserRegisterRepository implements UserRegisterRepository {

    private final JpaUserRegisterRepository jpaUserRegisterRepository;

    @Override
    public void create(UserRegister userRegister) {
        UserRegisterEntity entity = UserRegisterEntity.builder()
                .username(userRegister.getUsername())
                .password(userRegister.getPassword())
                .role(userRegister.getRole())
                .build();
        jpaUserRegisterRepository.save(entity);
    }

    @Override
    public Optional<UserRegister> findByUsername(String username) {
        return jpaUserRegisterRepository.findByUsername(username)
                .map(sss -> new UserRegister(sss.getId(), sss.getUsername(),
                        sss.getPassword(), sss.getRole()));
    }


}
