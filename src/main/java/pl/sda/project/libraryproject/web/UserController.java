package pl.sda.project.libraryproject.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.project.libraryproject.domain.book.Book;
import pl.sda.project.libraryproject.domain.user.User;
import pl.sda.project.libraryproject.domain.user.UserService;

@Controller
@RequestMapping("mvc/user")
@AllArgsConstructor
public class UserController {


private UserService userService;


    @GetMapping
    ModelAndView displayUserPage() {
        ModelAndView mav = new ModelAndView("users.html");
        mav.addObject("users", userService.getAll());
        return mav;
    }

    @GetMapping("/add")
    ModelAndView displayAddUserPage() {
        ModelAndView mav = new ModelAndView("addUser.html");
        mav.addObject("user", new User());
        return mav;

    }

    @PostMapping("/add")
    String handleAddUser(@ModelAttribute("user") User user) {
        userService.create(user);


        return "redirect:/mvc/user";


    }
}


