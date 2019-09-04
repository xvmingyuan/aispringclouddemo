package com.xmy.controller;

import com.xmy.entity.PageModel;
import com.xmy.entity.User;
import com.xmy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.SPageModel;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{page}/{limit}")
    public PageModel<User> findAll(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        return getPageModel(page, limit);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        user.setRegisterdate(new Date());
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

    public PageModel<User> getPageModel(int page, int size) {
        PageModel<User> pm = SPageModel.PageModel.pageModel();
        pm.count = userRepository.count();
        pm.data = userRepository.findAll(page > 0 ? (page - 1) * size : 0, size > 0 ? size : 10);
        return pm;
    }
}
