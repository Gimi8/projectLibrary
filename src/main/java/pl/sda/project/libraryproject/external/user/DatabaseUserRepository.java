package pl.sda.project.libraryproject.external.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import pl.sda.project.libraryproject.domain.user.User;
import pl.sda.project.libraryproject.domain.user.UserRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DatabaseUserRepository implements UserRepository {

    private JpaUserRepository jpaUserRepository;


    @Override
    public Optional<User> findOne(Long id) {
        return jpaUserRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void create(User user) {
jpaUserRepository.save(toEntity(user));
    }

    @Override
    public void update(User user) {
        if (!jpaUserRepository.existsById(user.getId())) {
            throw new IllegalStateException("Updated object not exist");
        }
        jpaUserRepository.save(toEntity(user));

    }

    @Override
    public void delete(Long id) {
jpaUserRepository.deleteById(id);
    }

    private User toDomain(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .age(entity.getAge())
                .build();
    }

    private UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .age(user.getAge())
                .build();

    }
}
