package com.example.cafe.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.cafe.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cafe.repository.UserRepository;
import com.example.cafe.domain.Product;
import com.example.cafe.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        user.setActive(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        List<Product> productlist1 = user.getProductList();
        List<Product> productlist = (userRepository.findByEmail(user.getEmail())).getProductList();
        productlist1.addAll(productlist);
        user.setProductList(productlist1);
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getUserById(long categoryId) {
        return userRepository.findById(categoryId);
    }
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
