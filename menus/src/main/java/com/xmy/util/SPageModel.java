package com.xmy.util;

import com.xmy.entity.Menu;
import com.xmy.entity.PageModel;

// 懒加载
public enum SPageModel {
    PageModel;
    private PageModel<Menu> pageModel = null;

    SPageModel() {
        pageModel = new PageModel<>();

    }

    public PageModel<Menu> pageModel() {
        return pageModel;

    }
}
