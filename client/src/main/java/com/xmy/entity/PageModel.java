package com.xmy.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {
    /**
     * code
     **/
    public int code = 0;
    /**
     * 信息
     **/
    public String msg = "";
    /**
     * 数据总数
     **/
    public int count = 0;
    /**
     * 当前页数据
     **/
    public List<T> data;
}
