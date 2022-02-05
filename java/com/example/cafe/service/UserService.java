package com.example.cafe.service;


import java.util.List;
import java.util.Optional;

import com.example.cafe.domain.User;

public interface UserService {

    public User findByEmail(String email);

    public void save(User user);

    public void update(User user);

    public List<User> findAllUser();

    public void deleteUser(long userId);
    public Optional<User> getUserById(long userId);
    public void updateUser(User user);
}
