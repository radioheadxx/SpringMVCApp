package mvc.controller;

import mvc.dao.UserDAOImpl;
import mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserDAOImpl userDAO;

    @RequestMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userDAO.getAllUsers();
        model.addAttribute("allUs", allUsers);
        return "all-users";
    }
}
