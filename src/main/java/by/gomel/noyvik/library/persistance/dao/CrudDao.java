package by.gomel.noyvik.library.persistance.dao;

import java.util.List;

public interface CrudDao<T> {


    T findById(long id);

    List<T> findAll();

    T save(T t);

    T update(T t);

    void deleteById(long id);
}
