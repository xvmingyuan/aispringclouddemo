package com.xmy.controller;

import com.xmy.entity.Menu;
import com.xmy.entity.PageModel;
import com.xmy.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuFeign menuFeign;

    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target) {
        return target;
    }

    @GetMapping("/add")
    public String prepareSave(Model model) {
        model.addAttribute("list", menuFeign.findAll());
        return "menu_add";
    }

    @GetMapping("/find")
    @ResponseBody
    public PageModel<Menu> find(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return menuFeign.find(page, limit);
    }

    @GetMapping("/edit/{id}")
    public String findById(@PathVariable("id") long id, Model model) {
        model.addAttribute("list", menuFeign.findAll());
        model.addAttribute("menu", menuFeign.findById(id));
        return "menu_edit";
    }

    @PostMapping("/save")
    public String save(Menu menu) {
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

    @PostMapping("/update")
    public String update(Menu menu) {
        menuFeign.update(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
//        orderFeign.deleteByMid(id);
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/menu_manage";
    }


}
