package com.xmy.controller;

import com.xmy.entity.Menu;
import com.xmy.entity.PageModel;
import com.xmy.entity.ResultData;
import com.xmy.entity.Type;
import com.xmy.repository.MenuRepository;
import com.xmy.repository.TypeRepository;
import com.xmy.util.SPageModel;
import com.xmy.util.SResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/index")
    public String index() {
        return this.port;
    }

    @GetMapping("/findAll/{page}/{size}")
    public ResultData<PageModel<Menu>> findAll(@PathVariable("page") int page, @PathVariable("size") int size) {
        ResultData<PageModel<Menu>> data = SResultData.ResultData.resultData();
        System.out.println("data.code:::" + data.code);
        data.data = getPageModel(page, size);
        data.msg = "success";
        data.code = size;
        System.out.println("data.code:::" + data.code);
        return data;
    }

    @GetMapping("/find/{page}/{size}")
    public PageModel<Menu> find(@PathVariable("page") int page, @PathVariable("size") int size) {
        return getPageModel(page, size);
    }

    @GetMapping("/count")
    public int count() {
        return menuRepository.count();
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id) {
        return menuRepository.findById(id);
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    @PutMapping("/update")
    public Boolean update(@RequestBody Menu menu) {
        return menuRepository.update(menu);
    }

    @DeleteMapping("/deleteById/{id}")
    public Boolean deleteById(@PathVariable("id") long id) {
        return menuRepository.deleteById(id);
    }

    public PageModel<Menu> getPageModel(int page, int size) {
        PageModel<Menu> pm = SPageModel.PageModel.pageModel();
        pm.code = 0;
        pm.msg = "";
        pm.count = menuRepository.count();
        pm.data = menuRepository.findAll(page > 0 ? (page - 1) * size : 0, size > 0 ? size : 10);
        return pm;
    }
}
