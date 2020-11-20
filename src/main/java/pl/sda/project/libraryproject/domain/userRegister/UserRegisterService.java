package pl.sda.project.libraryproject.domain.userRegister;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService {
private  final UserRegisterRepository userRegisterRepository;
private  final PasswordEncoder passwordEncoder;

    public void create(UserRegister user) {
        user.encodePassword(passwordEncoder);

        userRegisterRepository.create(user);

}}

