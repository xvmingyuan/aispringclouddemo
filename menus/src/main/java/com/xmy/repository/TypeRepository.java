package com.xmy.repository;

import com.xmy.entity.Type;

import java.util.List;

public interface TypeRepository {
    public List<Type> findAll();

    public int count();

    public Type findById(long id);

    public void update(Type type);

    public void save(Type type);

    public void deleteById(long id);


}
