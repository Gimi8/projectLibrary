package pl.sda.project.libraryproject.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.project.libraryproject.domain.user.User;
import pl.sda.project.libraryproject.domain.user.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("mvc/user")
@AllArgsConstructor
public class UserController {


private UserService userService;



    @GetMapping
    public ModelAndView displayRegisterPage() {
        ModelAndView mav = new ModelAndView("register.html");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping
    public String handleUserRegistration(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/mvc/login";
    }

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


    @GetMapping("/edit/{id}")
    ModelAndView displayEditUserPage(@PathVariable Long id ) {
        Optional<User> user = userService.getUserById(id);
        ModelAndView mav = new ModelAndView();
        if (user.isPresent()){
            mav.addObject("user",user.get());
            mav.setViewName("addUser.html");

        }else{
            mav.addObject("message",String.format("Użytkownik z id %d nie istnieje", id));
            mav.setViewName("error.html");
        }

        return mav;

    }


    @PostMapping("/addOrEdit")
    String handleAddUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addUser.html";
        }

        if (user.getId() != null) {
            userService.update(user);
        } else {
           userService.create(user);
        }
        return "redirect:/mvc/user";


    }
    @GetMapping("/delete/{id}")
    String handleDeleteUser(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/mvc/user";
    }



}


