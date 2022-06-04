package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller // тот же component, но с доп фишками
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("userList", userService.getAllUsers()); //получим всех людей из сервиса и передадим на отображение в представление
        return "/users";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("newUser") User user) {
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("redirectAll") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("redirectAll") User user, @PathVariable("id") int id) {
        userService.update(user, id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("userById", userService.findById(id)); //Получим одного человека по id из DAO и передадим на отображение в представление
        return "/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
