package com.xmy.controller;

import com.xmy.entity.*;
import com.xmy.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") long mid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        Menu menu = new Menu();
        menu.setId(mid);
        order.setUser(user);
        order.setMenu(menu);
        order.setDate(new Date());
        orderFeign.save(order);
        return "redirect:/account/redirect/order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public PageModel<Order> findAllByUid(@RequestParam("page") int page,
                                         @RequestParam("limit") int limit,
                                         HttpSession session) {
        User user = (User) session.getAttribute("user");
        return orderFeign.findAllByUid(user.getId(), page, limit);
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public PageModel<Order> findAllByState(@RequestParam("page") int page,
                                           @RequestParam("limit") int limit) {
        return orderFeign.findAllByState(0, page, limit);

    }

    @GetMapping("/updateState/{id}/{state}")
    public String updateState(@PathVariable("id") long id, @PathVariable("state") int state, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        Order order = new Order();
        order.id = id;
        order.aid = admin.getId();
        order.state = state;
        orderFeign.updateState(order);
        return "redirect:/account/redirect/order_handler";
    }
}
