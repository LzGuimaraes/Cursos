package dev.Cursos.cursos.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream().map(userMapper::map).collect(Collectors.toList());
    }
    public UserDTO getUserById(Long id) {
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.map(userMapper::map).orElse(null);
    }
    public UserDTO createUser(UserDTO userDTO) {
        UserModel userModel = userMapper.map(userDTO);
        userModel = userRepository.save(userModel);
        return userMapper.map(userModel);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public UserDTO alterUser(Long id, UserDTO userDTO) {
        Optional<UserModel> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserModel userUpdated = userMapper.map(userDTO);
            userUpdated.setId_user(id);
            UserModel userSaved = userRepository.save(userUpdated);
            return userMapper.map(userSaved);
        }
    return null;
    }
}
