package dev.Cursos.cursos.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDTO> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/all/{id}")
    public UserDTO getUsersById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("alter/{id}")
    public UserDTO alterUser(@PathVariable Long id, @RequestBody UserDTO updatedUser) {
        return userService.alterUser(id, updatedUser);
    }
    
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
}
