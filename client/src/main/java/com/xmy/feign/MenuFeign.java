package com.xmy.feign;

import com.xmy.entity.Menu;
import com.xmy.entity.PageModel;
import com.xmy.entity.ResultData;
import com.xmy.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{page}/{size}")
    public ResultData<PageModel<Menu>> findAll(@PathVariable("page") int page, @PathVariable("size") int size);

    @GetMapping("/menu/find/{page}/{size}")
    public PageModel<Menu> find(@PathVariable("page") int page, @PathVariable("size") int size);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PostMapping("/menu/save")
    public Boolean save(@RequestBody Menu menu);

    @PutMapping("/menu/update")
    public Boolean update(@RequestBody Menu menu);

    @DeleteMapping("/menu/deleteById/{id}")
    public Boolean deleteById(@PathVariable("id") long id);

    @GetMapping("/type/findAll")
    public List<Type> findAll();
}
