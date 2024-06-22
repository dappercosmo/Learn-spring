package com.flyway.flyway_example.service;

import com.flyway.flyway_example.model.Users;

import java.util.List;

public interface UserService {

    Users registerUser(Users users);
    List<Users> getAllUsers();
    Users updateUser(int id, Users users);
    String deleteUser(int id);
}
