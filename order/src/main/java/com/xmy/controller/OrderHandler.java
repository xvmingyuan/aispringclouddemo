package com.xmy.controller;

import com.xmy.entity.Order;
import com.xmy.entity.PageModel;
import com.xmy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import util.SPageModel;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Value("${server.port}")
    private String port;

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String defaultZone;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public PageModel<Order> findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        PageModel<Order> pm = SPageModel.PageModel.pageModel();
        pm.count = orderRepository.countByUid(uid);
        pm.data = orderRepository.findAllByUid(uid, page > 0 ? (page - 1) * limit : 0, limit > 0 ? limit : 10);
        return pm;
    }

    @DeleteMapping("/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid) {
        orderRepository.deleteByMid(mid);
    }

    @DeleteMapping("/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid) {
        orderRepository.deleteByUid(uid);
    }

    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public PageModel<Order> findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        PageModel<Order> pm = SPageModel.PageModel.pageModel();
        pm.count = orderRepository.countByState(0);
        pm.data = orderRepository.findAllByState(0, page > 0 ? (page - 1) * limit : 0, limit > 0 ? limit : 10);
        return pm;
    }

    @PostMapping("/updateState")
    public void updateState(@RequestBody Order order) {
        orderRepository.updateState(order.getId(), order.getAid(), order.getState());
    }

}

