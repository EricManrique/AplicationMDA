package com.example.Aplication;

import java.util.List;

public interface UserService {
    Users saveUser (Users user);
    List<Users> fetchUserList();
    Users updateUser(Users user, Long userId);

    Users findUser(Long id);

    Users findEmail(String email, String password);

    void deleteUserById(Long userId);
}
