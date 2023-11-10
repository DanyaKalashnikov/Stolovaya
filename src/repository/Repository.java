package repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAllEntity();

    T getEntityById(int id);

    void deleteEntity(T entity);

    void saveEntity(T entity);
}
