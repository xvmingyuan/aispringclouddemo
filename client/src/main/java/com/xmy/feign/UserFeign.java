package com.xmy.feign;

import com.xmy.entity.PageModel;
import com.xmy.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{page}/{limit}")
    public PageModel<User> findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);
}
