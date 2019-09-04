package com.xmy.util;

import com.xmy.entity.Menu;
import com.xmy.entity.PageModel;
import com.xmy.entity.ResultData;

public enum SResultData {
    ResultData;
    private ResultData<PageModel<Menu>> resultData = null;

    SResultData() {
        resultData = new ResultData<>();
    }

    public ResultData<PageModel<Menu>> resultData() {
        return resultData;

    }
}
