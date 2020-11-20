package pl.sda.project.libraryproject.api.model;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.project.libraryproject.domain.userRegister.UserRegister;
import pl.sda.project.libraryproject.domain.userRegister.UserRegisterService;

@RestController
@RequestMapping("/userRegister")
@RequiredArgsConstructor
public class UserRegisterApi {

    private final UserRegisterService userRegisterService;

    @PostMapping
    public void registerUser(@RequestBody UserRegister userRegister) {
        userRegisterService.create(userRegister);

    }
}
