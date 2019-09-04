package com.xmy.feign;

import com.xmy.entity.Order;
import com.xmy.entity.PageModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findAllByUid/{uid}/{page}/{limit}")
    public PageModel<Order> findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @DeleteMapping("/order/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid);

    @DeleteMapping("/order/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid);

    @GetMapping("/order/findAllByState/{state}/{page}/{limit}")
    public PageModel<Order> findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @PostMapping("/order/updateState")
    public void updateState(@RequestBody Order order);
}
