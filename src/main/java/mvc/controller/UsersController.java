package mvc.controller;

import mvc.model.User;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("allUs", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users/";
    }

    @GetMapping("update{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute(userService.findById(id));
        return "user-update";
    }

    @PostMapping("update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users/";
    }
}
