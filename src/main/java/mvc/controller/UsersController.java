package mvc.controller;

import mvc.model.User;
import mvc.service.UserService;
import mvc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService = new UserServiceImpl();

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
    @GetMapping("update/{user}")
    public String updateUserForm(@PathVariable("user") User user, Model model) {
        model.addAttribute(user);
        return "user-update";
    }
    @PostMapping("update/")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users/";
    }





//    @PostMapping("update/")
//    public String updateUser(User user) {
//        userService.updateUser(user);
//    }


//    @GetMapping("update/{id}")
//    public String updateUserForm(@PathVariable("id") Long id, Model model) {
//        User user = userService.findById(id);
//        model.addAttribute(user);
//        return "update/";
//    }

//    @RequestMapping("/addNewUser")
//    public String addNewUser(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "user-info";
//    }
//
//    @RequestMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/";
//    }
}
