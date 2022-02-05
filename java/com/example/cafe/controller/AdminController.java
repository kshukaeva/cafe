package com.example.cafe.controller;

import com.example.cafe.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.cafe.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index() {
        return "admin/index";
    }


    @GetMapping("UserList")
    public ModelAndView listCategory() {
        ModelAndView mv = new ModelAndView("admin/UserList");
        mv.addObject("userList", userService.findAllUser());
        return mv;
    }

    @PostMapping("addUser")
    public ModelAndView addUser(User user) {
        ModelAndView mv = new ModelAndView("admin/UserList");
        userService.save(user);
        mv.addObject("userList", userService.findAllUser());
        return mv;
    }

    @GetMapping("deleteUser/{userId}")
    public ModelAndView deleteUser(@PathVariable("userId")String userId) {
        ModelAndView mv = new ModelAndView("admin/UserList");
        userService.deleteUser(Long.parseLong(userId));
        mv.addObject("userList", userService.findAllUser());
        return mv;
    }

    @GetMapping("updateUser/{userId}")
    public ModelAndView updateUser(@PathVariable("userId")String userId) {
        ModelAndView mv = new ModelAndView("admin/updateUser");
        mv.addObject("User", userService.getUserById(Long.parseLong(userId)).get());
        return mv;
    }

}
