package com.xmy.repository;

import com.xmy.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public List<Menu> findAll(int index, int limit);

    public Integer count();

    public Menu findById(long id);

    public Boolean save(Menu menu);

    public Boolean update(Menu menu);

    public Boolean deleteById(long id);
}
