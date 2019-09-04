package util;

import com.xmy.entity.PageModel;
import com.xmy.entity.User;

// 懒加载
public enum SPageModel {
    PageModel;
    private PageModel<User> pageModel = null;

    SPageModel() {
        pageModel = new PageModel<>();

    }

    public PageModel<User> pageModel() {
        return pageModel;

    }
}
