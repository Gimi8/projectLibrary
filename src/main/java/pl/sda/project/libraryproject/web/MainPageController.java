package pl.sda.project.libraryproject.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.project.libraryproject.domain.book.Book;
import pl.sda.project.libraryproject.domain.book.BookService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MainPageController {
    private BookService bookService;

    @GetMapping("/")

    ModelAndView displayMainPage(){
        List<String> titles = bookService.getAll().stream()
                .map(Book::getTitle)
                .distinct()
                .collect(Collectors.toList());


        ModelAndView mav = new ModelAndView();
        mav.addObject("date", LocalDate.now().toString());
        mav.addObject("titles",titles);

        mav.setViewName("main.html");
        return mav;
    }




}
