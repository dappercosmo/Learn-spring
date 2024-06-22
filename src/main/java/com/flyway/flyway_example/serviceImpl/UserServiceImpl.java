package com.flyway.flyway_example.serviceImpl;

import com.flyway.flyway_example.model.Users;
import com.flyway.flyway_example.repository.UserRepository;
import com.flyway.flyway_example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Users registerUser(Users users) {
        Users newUser = new Users();
        newUser.setEmail(users.getEmail());
        newUser.setPassword(passwordEncoder.encode(users.getPassword()));
        newUser.setRole(users.getRole());
        return userRepository.save(newUser);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users updateUser(int id, Users users) {
        Users checkUser = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        checkUser.setEmail(users.getEmail());
        checkUser.setPassword(passwordEncoder.encode(users.getPassword()));
        checkUser.setRole(users.getRole());
        return userRepository.save(checkUser);
    }

    @Override
    public String deleteUser(int id) {
        Users checkUser = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        userRepository.deleteById(id);
        return "user deleted";
    }
}
