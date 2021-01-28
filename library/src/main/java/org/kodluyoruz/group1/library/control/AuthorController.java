package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.service.IAuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final IAuthorService authorService;

    @GetMapping("/authorslist")
    public String getAllActiveAuthors(Model model) {

        model.addAttribute("listAuthors", authorService.getAllActive());
        return "author_list";
    }

    @GetMapping("/saveAuthor")
    public String getCreateAuthor(Model model) {

        model.addAttribute("authorDTO", new AuthorDTO());
        return "add_author";
    }

    @PostMapping("/saveAuthor")
    public String postCreateBook(@Valid AuthorDTO authorDTO) {

        authorService.save(authorDTO);
        return "redirect:/authorslist";
    }

    @GetMapping("/updateAuthor/{id}")
    public ModelAndView getUpdateAuthor(@PathVariable Long id) {
        AuthorDTO authorDTO = (authorService.getAuthorById(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update_author");
        modelAndView.addObject("authorDTO", authorDTO);
        return modelAndView;
    }

    @PostMapping("/updateAuthor/{id}")
    public String postUpdateAuthor(@PathVariable Long id, AuthorDTO authorDTO) {

        authorService.update(id, authorDTO);
        return "redirect:/authorslist";
    }

    @PostMapping("/delete-author/{id}")
    public String deleteAuthor(@PathVariable Long id) {

        authorService.deleteById(id);
        return "redirect:/authorslist";
    }

//    @GetMapping("/{nameSurname}")
//    public Collection<Author> getAuthorsByNameSurname(@PathVariable String nameSurname) {
//        return authorService.findByNameSurname(nameSurname);
//    }
}