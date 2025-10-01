package dev.Cursos.cursos.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
    public UserModel getUserById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null);
    }
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public UserModel alterUser(Long id, UserModel updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId_user(id);
            return userRepository.save(updatedUser);
        }
        return null;
    }
}
