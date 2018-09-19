package pl.sdacademy.library.repository;

import java.util.List;

public abstract class AbstractRepository<T, ID> {

    public abstract T findOne(ID primaryKey);

    public abstract List<T> findPage(int pageIndex, int pageSize);

    public abstract List<T> findAll();

    public abstract T save(T entity);

    public abstract void delete(T entity);

    public abstract Long count();

    public abstract boolean exists(ID primaryKey);
}
