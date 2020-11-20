package pl.sda.project.libraryproject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.project.libraryproject.domain.userRegister.UserRegister;
import pl.sda.project.libraryproject.domain.userRegister.UserRegisterService;

@Controller
@RequestMapping("/mvc/register")
@RequiredArgsConstructor
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    @GetMapping
    public ModelAndView displayRegisterPage() {
        ModelAndView mav = new ModelAndView("register.html");
        mav.addObject("userRegister", new UserRegister());
        return mav;
    }

    @PostMapping
    public String handleUserRegistration(@ModelAttribute UserRegister userRegister) {
        userRegisterService.register(userRegister);
        return "redirect:/mvc/login";
    }
}
