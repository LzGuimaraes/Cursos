package dev.Cursos.cursos.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/all")
    public String getUser() {
        return "List of user";
    }

    @GetMapping("/all/{id}")
    public String getUsersById() {
        return "User By Id: ";
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
