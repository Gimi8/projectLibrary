package pl.sda.project.libraryproject.domain.userRegister;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService {
private  final UserRegisterRepository userRegisterRepository;
private  final PasswordEncoder passwordEncoder;



public void register (UserRegister userRegister){
    userRegister.encodePassword(passwordEncoder);
    userRegisterRepository.create(userRegister);


}
}

