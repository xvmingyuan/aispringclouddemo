package com.xmy.controller;

import com.xmy.entity.PageModel;
import com.xmy.entity.User;
import com.xmy.feign.OrderFeign;
import com.xmy.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public PageModel<User> findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return userFeign.findAll(page, limit);
    }

    @PostMapping("/save")
    public String save(User user) {
        userFeign.save(user);
        return "redirect:/account/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        orderFeign.deleteByUid(id);
        userFeign.deleteById(id);
        return "redirect:/account/redirect/user_manage";
    }
}
