package com.kraken.userservice.service;

import com.kraken.userservice.modal.Role;
import com.kraken.userservice.modal.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username , String rolename);
    User getUser(String username);
    List<User> getUsers();
}
