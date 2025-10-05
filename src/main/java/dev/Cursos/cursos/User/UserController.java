package dev.Cursos.cursos.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Cursos.cursos.User.dto.UserRequestDTO;
import dev.Cursos.cursos.User.dto.UserResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserResponseDTO> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/all/{id}")
    public UserResponseDTO getUsersById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("create")
    public ResponseEntity<UserResponseDTO>  createUser(@Valid @RequestBody UserRequestDTO userDTO) {
        UserResponseDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("alter/{id}")
    public UserResponseDTO alterUser(@PathVariable Long id,@Valid @RequestBody UserRequestDTO updatedUser) {
        return userService.alterUser(id, updatedUser);
    }
    
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
