package dev.Cursos.cursos.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public List<UserModel> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/all/{id}")
    public UserModel getUsersById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("create")
    public String createUser() {
        return "User created: ";
    }

    @PutMapping("alter/{id}")
    public String alterUser() {
        return "User altered: ";
    }
    @DeleteMapping("delete/{id}")
    public String deleteUser() {
        return "User deleted: ";
    }
    
}
