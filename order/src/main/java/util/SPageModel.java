package util;

import com.xmy.entity.Order;
import com.xmy.entity.PageModel;

// 懒加载
public enum SPageModel {
    PageModel;
    private PageModel<Order> pageModel = null;

    SPageModel() {
        pageModel = new PageModel<>();

    }

    public PageModel<Order> pageModel() {
        return pageModel;

    }
}
