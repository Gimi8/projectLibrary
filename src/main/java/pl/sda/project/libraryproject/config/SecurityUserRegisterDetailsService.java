package pl.sda.project.libraryproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.project.libraryproject.domain.userRegister.UserRegister;
import pl.sda.project.libraryproject.domain.userRegister.UserRegisterRepository;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityUserRegisterDetailsService implements UserDetailsService {

    private final UserRegisterRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> mapToUserDetails(user))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
//
    private UserDetails mapToUserDetails(UserRegister userRegister) {
        //JESLI DODAJESZ ROLE DO UZYTKOWNIKA TO MUSIMY JA POPRZEDZIC PREFIXEM ROLE_
        List<GrantedAuthority> authorities =
                Arrays.asList(new SimpleGrantedAuthority("ROLE_" + userRegister.getRole()));

        return new org.springframework.security.core.userdetails.User(userRegister.getUsername(),
                userRegister.getPassword(), authorities);
    }
}
