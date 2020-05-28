package ru.gothmog.ws.dao;

import java.util.List;

public interface GenericDao<T> {

     T create(T t);

     T update(T t);

     T get(Object id);

     void delete(Object id);

     List<T> getAll();

     long count();
}
